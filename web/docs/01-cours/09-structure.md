---
title: Exceptions
description: Exception, try catch throw throws
hide_table_of_contents: true
---

# Structurer son code

## Contenu

On peut rapidement se perdre quand on a plus de 100 lignes de code. Nous allons voir :
- quand faire une méthode et pourquoi (nommer, réutiliser, etc.)
- quand faire une classe et pourquoi (nommer, regrouper, etc.)
- les fonctions de refactor de l'environnement pour faire tout ça sans rien casser (parce qu'un travail qui marche c'est précieux)

<Row>

<Column>

:::warning Avant la séance (2h)

Regarder la video refactoring d'un monstre en kotlin


:::

</Column>

<Column>

:::tip Vidéos

<Video url="https://youtu.be/bJ4MXns-aqo" />

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

### Exercice TrouveLaValeur

Tu trouveras dans le repo du cours le projet XXX.

C'est un peu le bordel, réorganise le code et parle avec ton prof pour voir si:
- les méthodes ont de l'allure (le nom, ce qui rentre, ce qui sort)
-

### Exercice Bon ✔️ ou Non ❌

Voici des situations. Dites si le code est bon, ou pas, et pourquoi en 1 ligne

#### Exemple 1

```java
public void uneFonction(){
	try {
		//du code…
	} catch (Exception e){
		System.out.println("Erreur : " + e);
	} catch (ArrayOutOfBoundsException a){
		System.out.println("Erreur : " + a);
	}
}
```

#### Exemple 2

```java
public void calculerPoidsSupernova() {
	try {
		//calculs compliqués...
	} catch (NumberFormatException e) {}
}
```

### Exercice Attrape 🎣 ou Transmet 📡 ?

Voici des situations. Dites si on devrait attraper (**catch**) ou transmettre (**throws**) et pourquoi

#### Exemple 1

```java
public static void main() {
	try {
		calcul();
		lireFichier();
	} catch (ArithmeticException a) {
		println("Problème dans les valeurs du calcul");
	} catch (IllegalArgumentException i ) {
		println("Problème dans les paramètres du programme");		
	} catch (InterruptedException t){
		println("Problème avec le thread en cours");	
	}
}

public static void lireFichier(){
	// Code qui lit un fichier...
    // highlight-next-line
	// Q : Catch ou Throws?
}
```

#### Exemple 2

```java
public static void main( String[] args ){
	List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5);
	List<List<Integer> > lists = Lists.partition(myList, -1);
			
	// Ce code utilise la librairie Guava.
    // highlight-next-line
	// Q : Catch ou Throws?
}
```

#### Exemple 3

```java
public void uneFonction(){
	etape1();
	etape2();
	etape3();
	etape4();
	etape5();
}

public void etape3(){
	//Code qui génère une exception
    // highlight-next-line
	// Q : Catch ou Throws?
}
```

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
