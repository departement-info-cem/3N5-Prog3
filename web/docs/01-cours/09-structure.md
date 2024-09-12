---
title: Exceptions
description: Exception, try catch throw throws
hide_table_of_contents: true
---

# Structurer son code

## Contenu

On peut rapidement se perdre dans une fonction quand on a plus de 100 lignes de code. Nous allons voir :
- quand faire une méthode et pourquoi (nommer, réutiliser, etc.)
- les fonctions de refactor de l'environnement pour faire tout ça sans rien casser (parce qu'un travail qui marche c'est précieux)

<Row>

<Column>

:::warning Avant la séance (2h)

Regarder la video sur le refactoring en kotlin dans IntelliJ IDEA.

:::

</Column>

<Column>

:::tip Vidéos

<Video url="https://youtu.be/9Gd83g3elJQ" />

:::

</Column>

<Column>

:::info À faire pendant la séance

- Compléter les exercices de la semaine
- Penser sérieusement à quel refactor aurait du sens pour ton TP
- Continuer le **[premier travail](../tp/tp1)**

:::

</Column>

</Row>

:::note Exercices

### Exercice RefactorTonTP

En utilisant les outils de refactor d'IntelliJ IDEA, améliorez la lisibilité de ton TP1.

Après chaque refactor:
- valide que le comportement de ton application n'a pas changé
- fais un commit de refactor
- pousse le sur ton repo

[//]: # ()
[//]: # (### Exercice Bon ✔️ ou Non ❌)

[//]: # ()
[//]: # (Voici des situations. Dites si le code est bon, ou pas, et pourquoi en 1 ligne)

[//]: # ()
[//]: # (#### Exemple 1)

[//]: # ()
[//]: # (```java)

[//]: # (public void uneFonction&#40;&#41;{)

[//]: # (	try {)

[//]: # (		//du code…)

[//]: # (	} catch &#40;Exception e&#41;{)

[//]: # (		System.out.println&#40;"Erreur : " + e&#41;;)

[//]: # (	} catch &#40;ArrayOutOfBoundsException a&#41;{)

[//]: # (		System.out.println&#40;"Erreur : " + a&#41;;)

[//]: # (	})

[//]: # (})

[//]: # (```)

[//]: # ()
[//]: # (#### Exemple 2)

[//]: # ()
[//]: # (```java)

[//]: # (public void calculerPoidsSupernova&#40;&#41; {)

[//]: # (	try {)

[//]: # (		//calculs compliqués...)

[//]: # (	} catch &#40;NumberFormatException e&#41; {})

[//]: # (})

[//]: # (```)

[//]: # ()
[//]: # (### Exercice Attrape 🎣 ou Transmet 📡 ?)

[//]: # ()
[//]: # (Voici des situations. Dites si on devrait attraper &#40;**catch**&#41; ou transmettre &#40;**throws**&#41; et pourquoi)

[//]: # ()
[//]: # (#### Exemple 1)

[//]: # ()
[//]: # (```java)

[//]: # (public static void main&#40;&#41; {)

[//]: # (	try {)

[//]: # (		calcul&#40;&#41;;)

[//]: # (		lireFichier&#40;&#41;;)

[//]: # (	} catch &#40;ArithmeticException a&#41; {)

[//]: # (		println&#40;"Problème dans les valeurs du calcul"&#41;;)

[//]: # (	} catch &#40;IllegalArgumentException i &#41; {)

[//]: # (		println&#40;"Problème dans les paramètres du programme"&#41;;		)

[//]: # (	} catch &#40;InterruptedException t&#41;{)

[//]: # (		println&#40;"Problème avec le thread en cours"&#41;;	)

[//]: # (	})

[//]: # (})

[//]: # ()
[//]: # (public static void lireFichier&#40;&#41;{)

[//]: # (	// Code qui lit un fichier...)

[//]: # (    // highlight-next-line)

[//]: # (	// Q : Catch ou Throws?)

[//]: # (})

[//]: # (```)

[//]: # ()
[//]: # (#### Exemple 2)

[//]: # ()
[//]: # (```java)

[//]: # (public static void main&#40; String[] args &#41;{)

[//]: # (	List<Integer> myList = Arrays.asList&#40;1, 2, 3, 4, 5&#41;;)

[//]: # (	List<List<Integer> > lists = Lists.partition&#40;myList, -1&#41;;)

[//]: # (			)
[//]: # (	// Ce code utilise la librairie Guava.)

[//]: # (    // highlight-next-line)

[//]: # (	// Q : Catch ou Throws?)

[//]: # (})

[//]: # (```)

[//]: # ()
[//]: # (#### Exemple 3)

[//]: # ()
[//]: # (```java)

[//]: # (public void uneFonction&#40;&#41;{)

[//]: # (	etape1&#40;&#41;;)

[//]: # (	etape2&#40;&#41;;)

[//]: # (	etape3&#40;&#41;;)

[//]: # (	etape4&#40;&#41;;)

[//]: # (	etape5&#40;&#41;;)

[//]: # (})

[//]: # ()
[//]: # (public void etape3&#40;&#41;{)

[//]: # (	//Code qui génère une exception)

[//]: # (    // highlight-next-line)

[//]: # (	// Q : Catch ou Throws?)

[//]: # (})

[//]: # (```)

### Exercice Jimmy et Johnny 👨‍🎤👨‍💼

Jimmy et Johnny se chicanent depuis 10 ans. Chacun a écrit une méthode afin de lire un fichier. Jimmy dit que les deux méthodes sont équivalentes alors que Johnny dit que le résultat n'est pas le même. Qui a raison et pourquoi?

Testez le [code](https://github.com/departement-info-cem/3N5-Prog3/tree/main/code/Demo_Exceptions/src/main/java/sabourin/exercices) pour démontrer si les méthodes sont pareilles ou non.

```java
public static void lireDesFichiersJimmy(){
    for (int i = 0 ; i < 10 ; i++ ){
        try {
            lireFichier(i); 
        } catch (FileNotFoundException e) {
            System.out.println("fichier n'existe pas");
        }
    }
}

public static void lireDesFichiersJohnny(){
    try {
        for (int i = 0 ; i < 10 ; i++ ){
            lireFichier(i); 
        }
    } catch (FileNotFoundException e) {
        System.out.println("fichier n'existe pas");
    }
}	
```

:::
