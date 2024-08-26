---
title: Librairie standard
description: Librairies standard
hide_table_of_contents: true
---

# Kotlin, librairie standard

## Contenu

TODO on oublie hashcode et equals\
TODO on parle de collection mutable / pas mutable\
TODO on parle de set et list  Thème collection\
TODO on parle de fichiers écriture et lecture fichiers texte

<Row>

<Column>

:::danger Avant la séance (2h)

Explication en profondeur mutalibilité et immutabilité.

Kotlin peut utiliser :
- les librairies Java incluant tout le contenu de la librairie standard (exemple : java.util.List)
- la **[librairie standard de Kotlin](https://kotlinlang.org/api/latest/jvm/stdlib/)**, qui est une surcouche de la librairie Java.

Une liste mutable peut faire tout ce que peut faire une liste immuable, alors :
- pourquoi la immuable existe?
- pourquoi on recommande d'utiliser le plus possible des collection immuables?

Sources:
- **[Risques de la mutabilité](https://web.mit.edu/6.005/www/fa15/classes/09-immutability/#:~:text=The%20answer%20is%20that%20immutable,much%20harder%20to%20enforce%20contracts)**
- **[Limiter la mutabilité](https://kt.academy/article/ek-mutability)**

1. La source la plus importante de documentation sur la librairie standard est le javadoc.\
Parcourir une ou deux pages en partant de **[javadoc](https://docs.oracle.com/javase/7/docs/api/)** (max 20 minutes).
2. Lire le javadoc de la classe **[Set](https://docs.oracle.com/javase/7/docs/api/java/util/Set.html)** (max 10 minutes).
3. Regarder les vidéos de théorie
4. Commencer les exercices de la semaine.
5. Arrêter après 2 heures de travail

:::

</Column>

</Row>

<Row>

<Column>

:::tip Vidéos

<Video url="https://youtu.be/KhK604sQik8" />

<Video url="https://youtu.be/YxLB9Hc9GLI" />

<Video url="https://youtu.be/0nIQGQ6D6xw" />

<Video url="https://youtu.be/v4HM5iTfSoE" />

:::

</Column>

<Column>

:::info À faire pendant la séance

- Compléter les exercices de la semaine
- Continuer le **[travail pratique](../tp/tp1)** (à remettre bientôt!)

:::

</Column>


</Row>

:::note Exercices

Crée-toi un nouveau projet dans lequel tu pourras créer différents fichiers exécutables pour les exercices.

### Exercice EcrireFichier.kt

En utilisant la librairie standard, ton programme doit :

- écrire un fichier vide dans le dossier courant appelé vide.txt;
- créer un fichier texte contenant ton nom et ton prénom dans le dossier parent du dossier courant.

### Exercice LireFichier.kt

En utilisant la librairie standard, ton programme doit :

- prendre un ou plusieurs noms de fichiers en arguments de ligne de commande;
- afficher le contenu de chaque fichier passé en argument dans la console en les séparant par une ligne de -------------.

### Exercice ListeSimple.kt

Ton programme doit contenir :
- une fonction ***repete(n: Int, nombreFois: Int)*** qui renvoie une liste d'entiers avec tous les nombres de 1 à *n* répétés *nombreFois*.\
Par exemple, pour ***repete(4, 2)***, on doit obtenir **[1, 1, 2, 2, 3, 3, 4, 4]**;
- une fonction ***main*** qui teste la fonction précédente avec plusieurs valeurs de paramètres, et affiche les listes retournées avec *println()*.

### Exercice TriSimple.kt

Ton programme doit contenir :
1. une fonction ***triInverseALaMain(liste: List\<Double\>)*** qui renvoie la liste triée par ordre inverse.\
Par exemple, si on passe **[0.1, 12.34, -0.1234, 3.1416]** on doit obtenir **[-0.1234, 0.1, 3.1416, 12.34]**.\
Tu dois utiliser une liste mutable et une boucle;
2. une fonction ***triInverse(liste: List\<Double\>)*** qui fait la même chose, mais sans boucle et en utilisant une méthode de l'objet *List* reçu en paramètre;
3. une fonction ***main*** qui teste les deux fonctions précédentes avec plusieurs listes.

### Exercice TrouvePisCompte.kt

Ton programme doit contenir :
1. une fonction ***trouveALaMain(element: Int, liste: List\<Int\>): Boolean*** qui renvoie si la liste contient l'élément fourni ou pas.\
Tu dois parcourir la liste avec une boucle;
2. une fonction ***trouve(element: Int, liste: List\<Int\>): Boolean*** qui fait la même chose, mais sans boucle et en utilisant une méthode de l'objet *List*;
3. une fonction ***compteALaMain(element: Int, liste: List\<Int\>): Int*** qui renvoie le nombre d'apparitions de l'element dans la liste.\
Tu dois parcourir la liste avec une boucle;
4. une fonction ***compte(element: Int, liste: List\<Int\>): Int*** qui fait la même chose, mais sans boucle et en utilisant une méthode de l'objet *List*;
5. une fonction ***main*** qui teste les 4 fonctions sur plusieurs exemples.

### Exercice TriComparator.kt

Ton programme doit contenir une fonction ***triComplexe(liste: List\<Int\>): List\<Int\>*** qui renvoie la liste, triée selon un ordre un peu complexe :
- si un nombre contient moins de 7 qu'un autre, il doit être avant dans le tri;
- si 2 nombres ont le même nombre de 7, le plus petit devrait être avant dans la liste.

Par exemple, si la fonction reçoit :\
[1234, 747, 77, 1977, -71, 17, 7], elle doit retourner :\
[1234, -**7**1, **7**, 1**7**, **77**, **7**4**7**, 19**77**].

Le ***main*** de ton programme doit tester la fonction précédente avec plusieurs listes.

Tu peux utiliser des boucles si tu veux mais, idéalement, ton programme n'utiliserait que des fonctions de la librairie standard de Kotlin pour effectuer le tri en une seule ligne de code!

### Exercice Liste et références

Crée une classe **Truc** (fichier Truc.kt) avec un constructeur qui reçoit 2 valeurs pour instancier 2 propriétés :

- pipo (un Int);
- popi (une String).

Surcharge la méthode ***toString()*** de la classe Truc pour afficher les valeurs des 2 propriétés.

Crée un fichier exécutable **GererTrucs.kt**, et dans le ***main*** :

1. crée 3 objets de classe Truc dans les variables ***a***, ***b*** et ***c***, avec des valeurs différentes pour chacun;
2. crée une liste **liste1** et mets-y dans cet ordre : **[*a*, *b*, *c*]**;
3. crée une liste **liste2** et mets-y dans cet ordre : **[*b*, *c*, *a*]**;
4. affiche les 2 listes à l'aide de *println()*;
5. modifie les valeurs de l'objet ***a***;
6. réaffiche les 2 listes.

Dans un fichier **Trucs.md** à la racine du projet, réponds à ces questions :
1. L'objet ***a*** dans les listes a-t-il été modifié?
2. Pourquoi?
3. Est-ce une copie de l'objet ***a*** original?

Dans le doute, demande à ton prof.

### Exercice EntrezUnNombre.kt

En utilisant la fonction ***readln()***, crée un programme qui demande à l'utilisateur de taper un mot jusqu'à ce que ce soit un nombre entier (dans la console) :

```text {2,4,6}
Veuillez entrer un nombre :
pipo
Ceci n’est pas un nombre, veuillez entrer un nombre :
popi
Ceci n’est pas un nombre, veuillez entrer un nombre :
123
Merci, votre nombre est 123.
```

### Exercice Dictionnaire.kt (optionnel)

On veut garder en mémoire les notes de nos étudiants.\
Après mûre réflexion, on décide d'utiliser comme structure de données un **dictionnaire** (*Map*) avec la note de l'étudiant.e comme clé et son nom de famille comme valeur.

Évalue la solution proposée (bon / pas bon, et pourquoi).

1. Dans le *main*, crée la structure proposée et mets-y les paires suivantes :
   - Sanchez a eu 92%
   - Tremblay a eu 68%
   - Richard a eu 73%
2. Crée une autre fonction qui reçoit une *map* et qui parcourt ses paires (note, etudiant) pour les afficher dans la console, une par ligne.\
   Appelle ta fonction dans la *main*.\
   Le résultat doit ressembler à ceci :
```text {2,4,6}
NOTES
Sanchez a eu 92%.
Tremblay a eu 68%.
Richard a eu 73%.
```
3. Sur de nouvelles lignes dans ton *main* :
   - Ajoute un nouvel étudiant dans ta *map*, Gino Tremblay, qui a eu 30%.
   - Appelle de nouveau ta fonction pour afficher les notes.
   - Ajoute une nouvelle étudiante, Mauda Sasa, qui a eu 68%.
   - Affiche encore les notes de ta *map*.
- Que s'est-il passé?
- Pourquoi?
- A-t-on bien choisi la paire (clé, valeur) de notre *map*?
- Que proposes-tu?

:::
