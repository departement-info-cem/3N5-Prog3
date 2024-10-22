---
title: Structurer son code en Android
description: Structurer son code en Android
hide_table_of_contents: true
---

# Structurer son code en Android

[RecyclerView - String](../03-recettes/recycler-view-01-string.mdx)


<Row>

<Column>

:::danger Avant la séance (2h)

- Consulter ces 2 recettes :
    - [Structurer en package](../03-recettes/structure-package.mdx)
    - [Structurer en service / modèle](../03-recettes/service.mdx)
- Commencer les exercices. Arrêtez-vous quand vous aurez complété 2 heures.

<Row>


</Row>

:::

</Column>

<Column>

:::info Pendant la séance

- Compléter les exercices de la semaine.
- Structurer votre code du TP3 en vous inspirant des recettes et en discutant avec votre prof.

:::

</Column>

</Row>

:::note Exercices

### Exercice Packages

Essaie d'appliquer une des 2 approches de séparation en packages vus dans la [recette](../03-recettes/structure-package.mdx) sur ton 
projet de TP.

### Exercice Notes

Vous devez appliquer la [méthode](../03-recettes/service.mdx) de décomposition en entités et actions sur l'exemple suivant:

```
On cherche à réaliser une application permettant de gérer des étudiants et leurs notes. L'application permet de créer des épreuves avec une pondération. L'ensemble des épreuves donne une somme de poids de 100. On peut créer des étudiants dans le système. Finalement, on peut saisir les notes pour un étudiant et pour une épreuve.

Après la saisie de chaque nouvelle note d'étudiant, le système donne le détail de la situation de l'étudiant.

Prenez cet exemple pour votre application (TP). Vous devez définir le modèle de données ainsi que le service sous la forme des méthodes nécessaires.
```

:::
