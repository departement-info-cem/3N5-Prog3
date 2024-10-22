---
title: Tests
description: Tests unitaires
hide_table_of_contents: true
---

# Tests automatisés / unitaires

## Contenu

Nous reviendrons sur l'exercice Note, son service et le rôle des tests unitaires. On illustrera sur une classe et une méthode de calcul de la racine carrée.

- Premier élément pour exécuter le code
- Couvrir les cas fonctionnels et exceptionnels
- Limiter le temps d'exécution
- Assert pour garantir des choses dans le futur
- Calculer une couverture de code

<Row>

<Column>

:::warning Avant la séance (2h)

1. Lire la page Wikipedia sur les [tests](https://fr.wikipedia.org/wiki/Test_unitaire) (max 20 min).
2. Regarder les vidéos de théorie
3. Commencer les exercices de la semaine. Arrêter après 2 heures de travail



:::

</Column>

<Column>

:::tip Vidéos

<Video url="https://youtu.be/TsvblQf--nI" />

<Video url="https://youtu.be/odT2vpyqVN8" />

<Video url="https://youtu.be/IOpGBezfUww" />

PARLER DE TESTER AVEC UNE BD

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

Pour chaque exercice, vous devrez programmer des tests. Utilisez la couverture de code pour valider que le code est testé en entier.

### Exercice Aider un ami

Jimmy Jo, un étudiant de 3N5, a écrit le code [suivant](https://github.com/departement-info-cem/3N5-Prog3/tree/main/code/TestsExercice1). Modifiez son code pour respecter les règles suivantes :

- Classe entité : La BD assigne le ID de façon automatique
- Test 1 (OKBD) : Lorsqu'on crée notre objet modèle, on laisse son ID Null
- Service : Lance une exception quand il reçoit une personne avec un id ajouté manuellement
- Tests 1 & 2 : Vérifient correctement qu'un ID a été généré automatiquement

### Exercice CodePostal

Programmer la méthode suivante qui indique si un code postal canadien est valide.

```kotlin
fun isValidZipCode(zippy: String): Boolean {
    return true
}
```

Écrire les tests pour valider cette méthode.
- on accepte les minuscules et majuscules
- les 2 blocs peuvent être séparés par 0 1 ou 2 espaces ou un tiret
- Ok : "H1Y1E1", "H1Y 1E1", "h3Y 1E8"
- Ko : "H1Y &#8203; &#8203; &#8203; 1E1", "H1Y_1E1", "h3Y 1TO"

### Exercice ChatGPT (ou copilot) fait mes tests

En prenant ton service du TP3, demande à ChatGPT ou à copilot de générer les tests unitaires qui y correspondent.

En prenant les tests fournis, regarde si les critères suivants sont respectés:
- les tests ne passent pas si le code de mon application n'est pas encore fait (si tu l'as déjà fait remplace par du code qui renvoie une constante etc.)
- les tests couvrent 90% et plus des méthodes de service
- les tests passent quand ton code fonctionne
- les tests couvrent les différents cas d'exception

### (Optionnel) Exercice retour sur le TP1

En partant de ton code du TP1, crée des tests unitaires pour les différents méthodes. Tu peux utiliser un assistant IA
pour t'aider à produire tes tests.

Cela n'est possible que si tu avais découpé ton code en méthodes.

:::
