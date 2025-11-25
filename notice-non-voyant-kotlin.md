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
