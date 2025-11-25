# Manuel étudiant Kotlin pure en mode CLI (powershell lignes de commande)
Création du projet                 on passe par Intellij pour générer le projet

./gradlew build                    compile et sort les messages d'erreurs

./gradlew run                      roule l'application si le build.gradle  (ici demande à ton prof pour la config initiale du projet)
- ajouter "application" dans la balise plugins du build.gradle.kts
- ajouter une task en bas
```
plugins {
    ...
    id("application")
}
...
tasks.named<JavaExec>("run") {
    mainClass.set("org.example.MainKt")
}
```

./gradlew run --args='Alice test 123'    roule l'application en lui passant des arguments



# Manuel étudiant Kotlin pure en mode Intellij IDEA
alt + 1        explorateur du projet (comme explorateur de solution)

# Manuel étudiant Android en mode CLI (powershell lignes de commande)
./gradlew assembleDebug                  Permet de compiler une application et voir les erreurs  
Alt + v puis t                           amène au menu des tool Windows
- comment rouler les tests dans le terminal                    
- comment consulter le rapport HTML de l’exécution des tests            
- comment installer copilot CLI                                  
- comment tracer une exécution avec des println
- comment voir logcat depuis le CLI général
adb logcat System.out:V *:S               - comment voir logcat depuis le CLI seulement mes println
- comment exécuter une appli kotlin depuis le terminal (modification au build.gradle puis commande)
- comment voir tous les problèmes d’une appli Android en CLI Error Warning et Typos

# Manuel étudiant Android Studio
alt + 1                
explorateur du projet (comme explorateur de solution)
- comment lire une section de code puis plus grand puis plus grand dans Android Studio


Une collecte de raccourcis et procédures pour coder dans 3N5

alt + 1        explorateur du projet (comme explorateur de solution)


**alt + 6** Problems toutes les erreurs de compilation si tu fais enter sur le problème il te mène sur la ligne

Maj + F10 partir le projet




Logcat

Powershell "adb logcat System.out:V *:S" filtre tous les print println

si on souhaite mettre dans un fichier 

Pwershell "adb logcat -b all -c" efface logcat 

adb logcat System.out:V *:S > logcat_output.txt    permet de récupérer le logcat dans un fichier pour naviguer ensuite dedans

## exécuter application Android depuis powershell

## accéder au logcat depuis powershell

## cycle débogage Android Studio
- 

# Config de NVDA pour les caractères spéciaux (Merci à Pierre-Paul)
1. dans le menu d'options (MAJ + N).
2. Puis dans Préférences > Paramètres.
3. Puis Parole > Niveau de ponctuations et symboles (la pluspart ou tous).
4. Tu peux aussi aller ajuster exactement quel symboles sont dit et comment ils sont prononcé (J'ai essayer de changer "parenthèse gauche" pour que ce soit "paran G", mais sa portait plus a confusion.)



