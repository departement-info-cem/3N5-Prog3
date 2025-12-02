---
title: Copilot et IAG
description: Copilot et IAG
hide_table_of_contents: true
---

# Le pilote et le co-pilote

L'intelligence artificielle générative (IAG) va sans doute transformer le travail de développeur
de manière importante.

Le but de cette séance est de se faire une idée plus précise de
- ce que peut faire l'IAG en ce moment
- comment l'utiliser sans devenir moins compétent
- déterminer quelles sont les tâches

<Row>

<Column>

:::tip Avant la séance (2h)

1. Vérifier que vous avez activé le Pack Éducation : https://education.github.com/pack
2. Installer le plugin GitHub Copilot dans IntelliJ et Android Studio (un peu de recherche sur Google)
3. Activer votre Copilot Pro : https://github.com/github-copilot/free_signup

:::

</Column>

<Column>

:::info Démo

Petite démo de Copilot en mode agent par le professeur :
- Utilisation du mode agent
- Choisir un modèle dans le plugin Copilot (Claude, Gemini, GPT, etc.)
- Mettre en place un service pour le TP1 : explorer une page avec JSoup, extraire les courriels et les URL
- Mettre en place des tests automatiques du service
- Squelette d'interface CLI avec des prompts

Discussion en classe :
- Est-ce que Copilot va remplacer les développeurs ? Les développeurs juniors ?
- Comment s'en servir sans devenir dépendant ou moins compétent ?
- Développer, est-ce produire le code ? Comprendre le code ? Garantir à un client que le code fonctionne ?


:::

</Column>

</Row>

:::note Exercices de la semaine

## Exercice `Modeles.md`

Le plugin Copilot dans IntelliJ vous permet de choisir entre différents modèles d'IAG (Claude, Gemini, GPT, etc.).

On va reproduire l'expérience avec les modèles suivants :
- GPT-4.1 dans un projet appelé **AppliGPT**
- Claude Haiku 4.5 dans un projet appelé **AppliClaude**
- Gemini Pro 2.5 dans un projet appelé **AppliGemini**

Pour chaque modèle, faites les étapes suivantes :
1. Créer un projet de départ Android Studio avec le bon nom dans votre dépôt
2. Ouvrir le mode Agent de Copilot et choisir le modèle approprié
3. Commencer avec le prompt suivant :
```text
crée une interface Compose (Jetpack) avec une top bar contenant le titre **Accueil**,
un menu déclenché par le hamburger qui contient une zone en haut indiquant
l'utilisateur connecté puis les options Accueil avec une icône de maison et
Profil avec une icône de profil. Dans la top bar, je veux aussi une action avec
l'icône de partage qui pour l'instant déclenche juste un println qui dit "coucou"
dans logcat. Je veux aussi un Floating Action Button.
```
4. Valider le bon fonctionnement de l'application. Si ça ne fonctionne pas, le noter dans un commentaire
5. Essayer un prompt plus vague :
```text
Crée un écran de profil et traduis l'interface au complet
```
6. Valider le bon fonctionnement de l'application. Si ça ne fonctionne pas, le noter dans un commentaire
7. Enfin, utiliser un prompt très large :
```text
Gère la navigation entre les écrans existants, ajoute une liste de tâches à faire dans
l'écran d'accueil avec tout ce qu'il faut pour créer/modifier une tâche stockée en base de données,
ajoute des comptes avec inscription, connexion et déconnexion, et un écran de chargement
avec un logo généré qui montre que l'application gère des TODO lists.
```

Questions à rédiger dans `Modeles.md` à la racine du dépôt :
- Avez-vous un favori ? Pourquoi ?
- Avez-vous le contrôle précis sur le code produit ?
- Quel pourcentage du code comprenez‑vous ? 10 ? 20 ? 50 ? 80 ? 100 ?
- Quel modèle vous a semblé le plus performant ?

## Exercice `QueDesPrompts.md`

Essayez de reproduire l'interface suivante uniquement avec des prompts dans le mode Agent de Copilot.

[![a_reproduire](/img/copilotetmoi.png)](/img/copilotetmoi.png)

Copiez l'historique de vos prompts dans le fichier `QueDesPrompts.md` à la racine du dépôt.

:::
