# Manuel étudiant Kotlin (CLI et IntelliJ)

## Kotlin — création et exécution en CLI

Généralement on utilise IntelliJ pour générer le projet, puis on peut utiliser Gradle en CLI pour compiler et exécuter.

Commandes utiles :

./gradlew build
Compile et affiche les messages d'erreur

./gradlew run
Exécute l'application (si la tâche 'run' est configurée)

./gradlew run --args='Alice test 123'
Passer des arguments à l'application. Remarque : la commande est présentée ici sans guillemets pour que chaque ligne commence en colonne 0 ; selon votre shell, vous devrez peut‑être entourer la partie des arguments de guillemets (ex : --args="Alice test 123").

Configuration Gradle (extrait exemple)
```kotlin
plugins {
    // ...existing code...
    id("application")
}
// ...existing code...
application {
    mainClass.set("org.example.MainKt")
}
```

Si ./gradlew run ne fonctionne pas, ajoutez le plugin application et configurez mainClass dans build.gradle.kts comme montré ci‑dessus.

## Kotlin — IntelliJ IDEA (IDE)

Alt + 1 
explorateur de projet (Project)

Ctrl + Shift + F10  
exécuter le fichier courant

File > Run > Edit Configurations
éditer les configurations et ajouter des arguments en ligne de commande
