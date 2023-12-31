<div lang="fr">

# Présentation (FR)

Ce n'est pas mon propre "memory", mais actuellement, j'apprends le développement d'applications Android en suivant des tutoriels sur YouTube, notamment ceux de rpandey1234.
[rpandey1234 YouTube Channel](https://www.youtube.com/rpandey1234)

Dans le contexte de ma candidature pour une alternance chez Lunabee Studio, j'ai choisi de parler de mon expérience avec un tutoriel sur le thème du "memory". Cette section couvre des aspects tels que les mises en page dynamiques, la compréhension du fonctionnement des dépendances en Kotlin, la manipulation des fichiers XML, chargement d'images et Firebase, et d'autres aspects importants. Cependant, en tant que débutante, j'ai rencontré des problèmes lors de mes premières utilisations d'Android Studio. Mes projets de test ne se compilaient pas, ce qui m'a fait perdre beaucoup de temps à rechercher des solutions en ligne. De plus Android Studio était très lent.

Le tutoriel que j'ai suivi n'était pas à jour, ce qui a provoqué des problèmes avec la barre d'outils, qui ne s'affichait pas correctement, ainsi qu'avec les boutons qui étaient inutilisables. J'ai même dû recommencer mon projet à zéro à un moment donné. Malgré ces défis, j'ai voulu poursuivre le volet relatif au chargement d'images et à Firebase, mais j'ai encore rencontré des problèmes d'affichage des boutons, notamment celui du retour dans la barre d'outils.

J'espère que cette version vous convient.

# Utilisation et présentation du jeu
Le jeu Memory est un jeu de société où des cartes sont mélangées face cachée. Le but est de retourner deux cartes à la fois pour trouver des paires identiques. Si les cartes sont les mêmes, le joueur gagne un point et les conserve. Si elles sont différentes, il les retourne face cachée, et le joueur continue à chercher des paires. Le but est de trouver toutes les paires du jeu en utilisant la mémoire et la concentration.

Dans l'application, le jeu propose 3 niveaux: EASY, MEDIUM et HARD. 
Pour changer le niveau, il suffit d'appuyer sur le bouton (3 petits points) en haut à droite et cliquer sur "Choose new size". Choicissez parmi les 3 boutons radio.
- Easy (4 x 2)
- Medium (6 x 3)
- Hard (6 x 4)
Puis Ok.
Maintenant vous pouvez jouer et suivre l'avancement de votre partie grâce aux textes ci-dessous qui indiquent le nombre de mouvements et de pairs trouvées.
Il y a un bouton avec un logo flèche, celui-ci sert à "refresh", remettre la partie de 0.

Le bouton "Create custom game" est cliquable, il va vous mener à un nouvel écran mais vu que le tutoriel n'est pas à jour, je me suis arrêtée à là car les problèmes que je rencontrais me faisaient perdre beaucoup de temps. 


# Técharger un ZIP 
Voici un tuto : Cliquer sur "Code" en haut et "Download Zip"
https://blog.hubspot.com/website/download-from-github#repository


# Partie Technique

**Où trouver les informations :**

- Version de buildTools, dépendances, versions de compileSdk et minSdk : Vous pouvez les trouver dans le fichier `build.gradle.kts` de votre module d'application.

**Solutions aux problèmes courants :**

- Méthode 1 : Résoudre le problème spécifique ":app est actuellement compilé contre android-33" en suivant ce [tutoriel vidéo](https://youtu.be/aSy1mgKz3Vw?si=a0B5XdFj6AssHpd2).

- Méthode 2 : Résoudre les problèmes provenant de l'IDE et autres. Cliquez sur "Files," puis "Invalidate Caches," puis cochez les options et cliquez sur "Invalidate and Restart."

- Méthode 3 : Résoudre les conflits de dépendances, compilation et autres. Allez dans "Build," puis "Clean Project," suivi de "Rebuild Project."

# APK
Voici l'APK, sur android.
https://github.com/Joceima/my_memory_not_mine/blob/test2/app-debug.apk



</div>


--------------------------------------------------------------------------------------------------------------------------------------------  <!-- Ligne horizontale -->


<div lang="en">
This is not my own "memory", but currently I am learning Android application development by following tutorials on YouTube, notably those by rpandey1234.
https://www.youtube.com/rpandey1234

In the context of my application for a work-study program at Lunabee Studio, I chose to talk about my experience with a tutorial on the theme of memory. This topic covered dynamic layouts, understanding how dependencies work in Kotlin, XML files, project structure and other aspects. However, as a beginner, I encountered some problems during my first uses of Android Studio. My test projects were not compiling, causing me to waste a lot of time searching for solutions online.

The tutorial I followed was not up to date, which caused issues with the toolbar not displaying correctly, as well as the buttons being unusable. I even had to start my project from scratch at one point. Despite these challenges, I wanted to continue the part relating to loading images and Firebase, but I still encountered problems with the display of the buttons, in particular that of returning to the toolbar.

I hope this version suits you.
</div>





