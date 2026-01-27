---
title: Tests
description: Tests unitaires
hide_table_of_contents: true
---

# Tests automatisés / unitaires 🧪

## Contenu

1. Comment utiliser copilot ou chatGPT pour générer des tests unitaires
2. Comment s'assurer que les tests sont pertinents

<Row>

<Column>

:::warning Avant la séance (2h)

1. Regarder les vidéos de théorie
2. Commencer les exercices de la semaine. Arrêter après 2 heures de travail

:::

</Column>

<Column>

:::tip Vidéos

<Video url="https://youtu.be/TsvblQf--nI" />

<Video url="https://youtu.be/odT2vpyqVN8" />

<Video url="https://youtu.be/IOpGBezfUww" />

:::

</Column>

<Column>

:::info À faire pendant la séance

Compléter les exercices de la semaine

Continuer le [troisième travail](../tp/tp3)

:::

</Column>

</Row>

:::note Exercices

Pour chaque exercice, vous devrez programmer des tests, les exécuter et valider que le code est ok.

### Exercice CodePostal

Programmer la méthode suivante dans un projet kotlin similaire à ce qu'on faisait pour le TP1.

```kotlin
fun isValidZipCode(zippy: String): Boolean {
    return true
}
```
Tu vas sans doute trouver des librairies pour faire ça ou des expressions régulières. Comme ces expressions régulières sont
assez complexes, on va les tester pour s'assurer qu'elles font ce qu'on attend.

Écrire les tests pour valider cette méthode dans un fichier **Tests.kt**.
- utilise copilot pour savoir où tu devrais créer ton fichier dans le projet et ajouter les librairies si nécessaire
- produis les tests pour les cas suivants avec copilot :
  - on accepte les minuscules et majuscules
  - les 2 blocs peuvent être séparés par 0 1 ou 2 espaces ou un tiret
  - Ok : "H1Y1E1", "H1Y 1E1", "h3Y 1E8"
  - Ko : "H1Y &#8203; &#8203; &#8203; 1E1", "H1Y_1E1", "h3Y 1TO"

### Exercice Courriel

Programmer la méthode suivante dans un projet kotlin.

```kotlin
fun isValidEmail(courriel: String): Boolean {
    return true
}
```
Tu vas sans doute trouver des librairies pour faire ça ou des expressions régulières. Comme ces expressions régulières sont
assez complexes, on va les tester pour s'assurer qu'elles font ce qu'on attend.

Écrire les tests pour valider cette méthode dans un fichier **Tests.kt**.
- utilise copilot pour savoir où tu devrais créer ton fichier dans le projet et ajouter les librairies si nécessaire
- écris les tests pour les cas suivants avec copilot :
  - on accepte les minuscules et majuscules
  - Ok : "bob@smith.org", "a.b.c@pipo.com", "Rodgere.Federer@tennis.info"
  - Ko : "bob@smith", "a..b@popi.org", "john.doe@.com", "john.doe@plop.c"

<!--
### IMPORTANT : Exercice transformer mon service pour les tests

On va modifier le service pour qu'il soit testable en injectant la BD plutôt que le context:

Remplace
```kotlin
class DupontService(context: Context) {

    private val database : SujetVoteDataBase = UtilitaireBD.get(context)
    private val dao : SujetVoteDAO = database.dao()
```
Par 
```kotlin
class DupontService(db: SujetVoteDataBase) {
    
    private val dao : SujetVoteDAO = db.dao()
```

Chaque appel au service dans l'application sera maintenant fait avec
```kotlin
val service = DupontService(UtilitaireBD.get(context))
```
au lieu de 
```kotlin
val service = DupontService(context)
```

Pour les tests de ton service tu pourrais utiliser la BD de tests soit
```kotlin
val db = UtilitaireBD.getForTests(context)
val service = DupontService(db)
// appels à mes méthodes de service
```
-->

### Exercice ChatGPT (ou copilot) fait mes tests

En prenant ton service du TP3, demande à ChatGPT ou à copilot de générer les tests unitaires qui y correspondent.

Pour ChatGPT
```
ChatGPT, peux-tu me générer des tests unitaires Android pour mon service dont voici le code source CODE SOURCE
```

Pour Copilot, tu peux:
1. créer une classe de test dans la section androidTest appelée TestsDupontService
2. commencer un commentaire avec // test de la fonction xxx
3. en sautant une ligne, il devrait te suggérer un test et tu devrais pouvoir appuyer sur tab pour l'ajouter
4. tu peux aussi utiliser copilot chat pour lui demander de générer des tests de manière similaire à ChatGPT

En prenant les tests fournis, regarde si les critères suivants vus en cours sont respectés:
- les tests ne passent pas si le code de mon application n'est pas encore fait (si tu l'as déjà fait remplace par du code qui renvoie une constante etc.)
- les tests passent quand ton code fonctionne
- les tests couvrent les différents cas d'exception
- les tests ne modifient pas l'état de la BD sur le téléphone mais utilisent une BD en mémoire

### Exercices : est-ce que l'IA a fait une bonne job?

On va essayer de valider que les tests produits par l'IA sont pertinents:
- on va remplacer le code de chaque méthode de service par un throw UnsupportedOperationException() pour voir si les tests échouent
- essentiellement un test qui échoue toujours ou réussit toujours ne teste rien
- regarde si tests semblent correspondre à ce qui marche dans ton travail
- valide si tu trouves des cas problématiques dans des cas limites (tu peux générer ces tests avec l'IA) : 
  - moyenne mal calculée, 
  - vote avec un id qui ne correspond à rien
  - un nom de votant extrêmement long (mettons 4000 caractères)
  - un contenu de sujet extrêmement long (mettons 4000 caractères)
  - etc.

Mettons qu'on remplace le code de cette méthode:
```kotlin
fun ajouterSujet(contenu: String) : Long{
        val sujet = Sujet()
        sujet.contenu = contenu
        val id = dao.ajouterSujet(sujet) // retourne l'id du sujet ajouté
        // validation du contenu
        if (contenu.length == 0){
            throw TexteVideException()
        }
        if (contenu.length < 5){
            throw TexteCourtException()
        }
        val existant : Optional<Sujet> = dao.sujetParContenu(contenu)
        if (existant.isPresent){
            throw DejaPresentException()
        }
        return id
    }
```
- est-ce que tes tests passent?
- est-ce que le code est ok?
- quelle modification faire au test pour qu'il teste mieux / plus?

### (Optionnel) Exercice retour sur le TP1

En partant de ton code du TP1, crée des tests unitaires pour les différents méthodes. Tu peux utiliser un assistant IA
pour t'aider à produire tes tests.

Cela n'est possible que si tu avais découpé ton code en méthodes pendant la séance du refactoring.

:::
