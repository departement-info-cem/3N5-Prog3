# 3N5 programmation 3

Dans ce cours, nous allons changer de langage pour Kotlin:
- nous allons t'accompagner dans l'apprentissage d'un nouveau langage (après C#)
- nous allons utiliser Android dans la 2ème partie du cours pour faire l'interface graphique

## standards pour les vidéos et exemples Kotlin
- kotlin
- gradle comme système de build (permet d'avoir le même format de dépendances que pour Android)
- on déclare les types pour les var et val
- nom de package org.nomdefamille 
- pour les exemples qc.monpays

Ce gabarit est simplement le projet de départ du produit [Docusaurus](https://docusaurus.io/) développé par l'équipe de Facebook, avec quelques configurations prédéfinies pour le département d'informatique du CÉGEP Édouard Montpetit. Nous vous encourageons fortement à aller jeter un coup d'oeil aux références ci-bas pour en apprendre davantage sur les possibilités qu'offre Docusaurus.

## Pour bien commencer

1. Sur Github, faite un *fork* de ce projet. Le standard de nomenclature au département est `sigle-nom-du-cours` ex : `4N6-Mobile`.
2. Clonez et ouvrez le projet forké dans votre éditeur de code préféré.
3. Dans l'onglet `Settings` de votre repository, dans la section **Pages**, dans la sous section **Build and deployment**, **Source**, sélectinonez `GitHub Actions`.
4. Dans l'onglet `Actions` de votre repository, acceptez le conditions pour le déploiement.
5. Le fichier `config.json` doit être modifié pour contenir les informations liées à votre cours. `nomUrl` doit correspondre au nom du repository Github créé.
6. Voir [Installation](#installation) et [Développement Local](#développement-local) pour voir comment démarrer le serveur (**à partir du répertoire *web***).
7. Modifiez les documents Markdown qui sont dans la répertoire `docs` selon vos besoins.
8. Profit

## standards pour les vidéos et exemples en Android
- kotlin
- script de build en kotlin kts
- LinearLayout comme outil de base pour la mise en page
- nom de package org.nomdefamille
- pour les exemples qc.monpays
- toujours view binding et jamais findViewById

## idées

- faire des exercices où on utilise exclusivement le Layout Inspector pour déterminer une taille en dp sur un weight
- faire un exercice avec un layout existant et on doit y ajouter un élément

### Prérequis

Vous devez avoir installé les logiciels suivants sur votre poste :

- [NodeJS](https://nodejs.org/en/download/prebuilt-installer)
- NPM (normalement inclus dans l'installation de NodeJS

### Instruction

Dans un terminal, déplacez vous dans le répertoire `web`.

```
$ cd web
```

Si ce n'est pas déjà fait, installez les dépendances avec NPM.

```
$ npm install
```

Démarrez le serveur local.

```
$ npm start
``` 

## mantras pour le cours de programmation 3

"Toujours mettre des annotations de types sur tes val et tes var"

"50 lignes par méthode maximum" --> GENERALISER

"Il faut attraper l'exception quelque part non?" --> GENERALISER

"Je mets un weight dans mon LinearLayout alors c'est 0dp"

Tout le code poussé sur la branche `main` de ce dépôt est automatiquement déployée sur [https://info.cegepmontpetit.ca/nom-du-repo-github/](https://info.cegepmontpetit.ca/nom-du-repo-github/) à l'aide de Github Actions.

## Avancé

Des composantes supplémentaires ont été développées par Pierre-Olivier Brillant. Vous pouvez vous référer à la section [Wiki](https://github.com/departement-info-cem/depinfo-gabarit/wiki) de ce repository, ou vous adresser directement à lui pour en savoir plus.

## Références

- [Guide Markdown de base](https://www.markdownguide.org/getting-started/)
- [Guide Markdown étendu pour Docusaurus](https://docusaurus.io/fr/docs/markdown-features)
