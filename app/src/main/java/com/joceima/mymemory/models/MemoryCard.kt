package com.joceima.mymemory.models

import android.adservices.common.AdTechIdentifier

data class MemoryCard (
    val identifier: Int,
    var isFaceUp: Boolean = false,
    var isMatched: Boolean = false

)