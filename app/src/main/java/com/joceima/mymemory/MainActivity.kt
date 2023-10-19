package com.joceima.mymemory

import android.animation.ArgbEvaluator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
//import android.widget.Toolbar //ici
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.joceima.mymemory.models.BoardSize
import com.joceima.mymemory.models.MemoryCard
import com.joceima.mymemory.models.MemoryGame
import com.joceima.mymemory.utils.DEFAULT_ICONS
import android.content.Context
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {

    companion object{
        private const val TAG = "MainActivity"
    }


    // ils vont être crées dans le onCreate ce qui explique le lateinit
    private lateinit var clRoot: ConstraintLayout
    private lateinit var rvBoard: RecyclerView
    private lateinit var tvNumMoves: TextView
    private lateinit var tvNumPairs: TextView
    private lateinit var toolbar: Toolbar // ici tool bar

    private lateinit var adapter: MemoryBoardAdapter
    private lateinit var memoryGame: MemoryGame
    private var boardSize:BoardSize = BoardSize.EASY

    // ICI -------------------------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtenez la référence de la Toolbar depuis la mise en page
        toolbar = findViewById(R.id.toolbar)

        // Définissez la Toolbar comme barre d'outils de l'activité
        setSupportActionBar(toolbar)

        // Référencement des autres éléments de la mise en page
        clRoot = findViewById(R.id.clRoot)
        rvBoard = findViewById(R.id.rvBoard)
        tvNumMoves = findViewById(R.id.tvNumMoves)
        tvNumPairs = findViewById(R.id.tvNumPairs)

        setupBoard()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mi_refresh -> {
                // Setup the game again
                if(memoryGame.getNumMoves()>0 && !memoryGame.haveWonGame()){
                    showAlertDialog("Quit your current game ?",null,View.OnClickListener {
                        setupBoard()
                    })
                } else {
                    setupBoard()
                }
            }
            R.id.mi_new_size -> {
                showSizeDialog()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showSizeDialog() {
        val boardSizeView = LayoutInflater.from(this).inflate(R.layout.dialog_board_size, null)
        val radioGroupSize= boardSizeView.findViewById<RadioGroup>(R.id.radioGroup)
        when (boardSize){
            BoardSize.EASY -> radioGroupSize.check(R.id.rbEasy)
            BoardSize.MEDIUM -> radioGroupSize.check(R.id.rbMedium)
            BoardSize.HARD ->radioGroupSize.check(R.id.rbHard)
        }
        showAlertDialog("Choose new size",boardSizeView, View.OnClickListener {
            //Set a new value for the board size
            boardSize = when (radioGroupSize.checkedRadioButtonId){
                R.id.rbEasy -> BoardSize.EASY
                R.id.rbMedium -> BoardSize.MEDIUM
                R.id.rbHard -> BoardSize.HARD
                else -> BoardSize.HARD
            }
            setupBoard()
        })
    }

    private fun showAlertDialog(title: String, view: View?, positiveClickListener: View.OnClickListener) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)

        // Vérifiez si la vue est fournie et ajoutez-la à la boîte de dialogue
        if (view != null) {
            builder.setView(view)
        }

        builder.setNegativeButton("Cancel", null)
        builder.setPositiveButton("Ok") { _, _ ->
            positiveClickListener.onClick(null)
        }

        // Créez et affichez la boîte de dialogue
        val dialog = builder.create()
        dialog.show()
    }

    // ------------------------------------------------------------------------------------

    private fun setupBoard() {
        when (boardSize){
            BoardSize.EASY -> {
                tvNumMoves.text = "Easy: 4 x 2"
                tvNumPairs.text = "Pairs : 0 / 4"
            }
            BoardSize.MEDIUM -> {
                tvNumMoves.text = "Medium: 6 x 3"
                tvNumPairs.text = "Pairs : 0 / 9"
            }
            BoardSize.HARD -> {
                tvNumMoves.text = "Hard: 6 x 6"
                tvNumPairs.text = "Pairs : 0 / 12"
            }
        }
        tvNumPairs.setTextColor(ContextCompat.getColor(this,R.color.color_progress_none))
        memoryGame = MemoryGame(boardSize)
        adapter = MemoryBoardAdapter(this, boardSize, memoryGame.cards, object : MemoryBoardAdapter.CardClickListener {
            override fun onCardClicked(position: Int) {
                updateGameWithFlip(position)
            }

        })
        rvBoard.adapter=adapter
        rvBoard.setHasFixedSize(true)
        rvBoard.layoutManager = GridLayoutManager(this,boardSize.getWidth())
    }


    private fun updateGameWithFlip(position: Int) {
        // on checke les erreurs
        if(memoryGame.haveWonGame()){
            Snackbar.make(clRoot,"You already won", Snackbar.LENGTH_LONG).show()
            return
        }
        if(memoryGame.isCardFaceUp(position)){
            Snackbar.make(clRoot,"Invalid move", Snackbar.LENGTH_SHORT).show()
            return
        }

        if(memoryGame.flipCard(position)){
            Log.i(TAG,"Found a match! Num pairs found: ${memoryGame.numPairsFound}")
            val color = ArgbEvaluator().evaluate(
                memoryGame.numPairsFound.toFloat()/boardSize.getNumPairs(),
                ContextCompat.getColor(this,R.color.color_progress_none),
                ContextCompat.getColor(this,R.color.color_progress_full),
            ) as Int
            tvNumPairs.setTextColor(color)
            tvNumPairs.text="Pairs: ${memoryGame.numPairsFound} / ${boardSize.getNumPairs()}"
            if(memoryGame.haveWonGame()){
                Snackbar.make(clRoot, "You won! Congratulations", Snackbar.LENGTH_LONG).show()
            }
        }
        tvNumMoves.text ="Moves: ${memoryGame.getNumMoves()}"
        adapter.notifyDataSetChanged()
    }
}