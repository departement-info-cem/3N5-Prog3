# Intra A24 - Enoncée

## Fichier (4 points)

### Lire (1 point)

- (1 point) Affiche dans la console le contenu du fichier message.txt qui se trouve dans le projet de départ.

### Écrire (3 points)

- (1 point) S’il n’y a pas 2 éléments dans le paramètre args, affiche un message d'erreur, et retourne la valeur -1.
- (1 point) Crée un fichier dans le répertoire du projet, dont le nom sera déterminé par le premier argument.
          Par exemple, si l’argument est « pipo.txt » l’application crée le fichier dans le dossier du projet avec le
          nom « pipo.txt ».
- (1 point) Le fichier aura comme contenu le texte contenu dans le 2ème élément qui est dans le paramètre args.

Si tout s'est bien passé, on retourne la valeur 1.

## Algo (3 points)

Tu dois faire un programme en Kotlin qui calcule la racine en base 2 d'un nombre, en te basant sur le pseudo-code fourni.

- (3 points) Tu dois traduire le pseudo-code fourni pour programmer la fonction racineCarre.
- (1 point) Tu dois inclure toutes les annotations de type sur les variables.

```txt
racineCarre(x qui est un nombre en virgule flottante)
    resultat est initialisé à 0,0
    Tant que (resultat + 1) * (resultat +1) est inférieur ou égal à x faire
        resultat++
    fin du tant que
    remplir un tableau appelé fractions avec les valeurs 0,1 puis 0,01 puis 0,001 puis 0,0001
    pour fraction dans fractions faire
        initialiser base avec la valeur de resultat
        pour chaque chiffre entre 0 et 9 inclus, faire
            initialiser test avec la valeur de base + (fraction * chiffre)
            si test multiplié par test est inférieur ou égal à x
            alors on veut que resultat prenne la valeur de test
        fin du pour sur les chiffre
    
    fin du pour sur les fraction
    renvoyer resultat
```

## Jsoup (4 points)


Cette question vise à évaluer ta capacité à lire de la documentation.

Tu devras donc te référer à la documentation officielle de jsoup, qui est disponible ici : https://jsoup.org/


La page web `https://info.cegepmontpetit.ca/3N5-Prog3/intraA24-2.html` ne contient rien dans la balise `body`.


Pour chaque string de la liste donnée en paramètre, tu dois ajouter une nouvelle div dans la balise `body`, qui contient la string.

Une fois que les modifications ont été appliquées, tu dois retourner le document modifié, et imprimer le html modifié dans la console.

Pour tester le résultat, tu peux enregistrer le code html dans un fichier, ou simplement copier le code html qui est dans la console, le mettre dans un fichier html, et l'ouvrir dans un navigateur.

Tu devrais voir les mots "Comment est votre blanquette?" qui tournent, étalés verticalement, avec un fond bleu.

- (3 point) Chaque élément demandé est présent dans le document retourné.
- (1 point) Le contenu de la page html modifiée doit être imprimé dans la console.

Exemple du body avant :

```html
<body></body>
```

Exemple du body après :

```html
<body>
    <div>Comment</div>
    <div>est</div>
    <div>votre</div>
    <div>blanquette ?</div>
</body>
```

## Total sur 11 points
