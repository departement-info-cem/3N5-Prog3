# Manuel étudiant Kotlin pure en mode CLI (powershell lignes de commande)
Création du projet                 on passe par Intellij pour générer le projet

./gradlew build                    compile et sort les messages d'erreurs

./gradlew run                      roule l'application si le build.gradle  (ici demande à ton prof pour la config initiale du projet)
- ajouter "application" dans la balise plugins du build.gradle.kts
- ajouter la balise application qui pointe vers le fichier avec la fonction "main"
```
plugins {
    ...
    id("application")
}
...
application {
    mainClass.set("org.example.MainKt")
}
```

./gradlew run --args='Alice test 123'    roule l'application en lui passant des arguments



# Manuel étudiant Kotlin pure en mode Intellij IDEA
alt + 1                            explorateur du projet (comme explorateur de solution)
CTRL + MAJ + F10                     executer le fichier courant
File > Run > Edit configuration        permet d'éditer les foncifgurations et ajouter arguments en ligne de commandes


