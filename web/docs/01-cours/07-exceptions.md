---
title: Exceptions
description: Exception, try catch throw throws
hide_table_of_contents: true
---

# Exceptions, lancer throw(s) et attraper catch

## Contenu

Video à faire:
- pile d'appels dans le débogueur
- ce qui se passe quand on lance une exception
- dans la pile d'appels, on peut laisser passer ou attraper
- syntaxe en kotlin
- si personne n'attrape, l'application crash, et on voit une trace (trace) de pile (stack) d'appels communément appeleé 
**stacktrace** 
- dans une application, on devrait avoir une fonction qui attrape. Si ce n'est pas le cas, faire un gros try catch dans le main
- dans une librairie, ce n'est pas le cas, on peut lancer des exceptions au programmeur de l'appli pour qu'il réagisse au problème

Recette:
1. identifier les bouts de codes qui pourraient lancer une exception
2. se demander qui devrait l'attraper
3. si on ne sait pas, attraper au point d'entrée (main) et afficher un message d'erreur "une erreur inconnue est survenue"

Sources:
- https://kotlinlang.org/docs/exceptions.html

```kotlin
try {
    // some code
} catch (e: SomeException) {
    // handler
} finally {
    // optional finally block
}
```

Cette semaine nous discuterons d'abord de comment gérer des exceptions lancées par le code qu'on utilise. Plus précisement, nous parlerons des 2 choix principaux:

- Attraper une exception (catch d'un "try catch") : attraper l'exception et gérer la situation
- Laisser passer l'exception. On espère alors qu'une des méthodes de la pile d'appels va attraper.

Nous discuterons du fait qu'il faut attraper l'exception quelque part si on veut éviter un crash de l'application.

Finalement nous parlerons de la possibilité de définir des classes d'exceptions (il suffit d'étendre la classe Exception).

<Row>

<Column>

:::warning Avant la séance (2h)

Vous regarderez le projet **[demo exceptions](https://github.com/departement-info-cem/3N5-Prog3/tree/main/code/Demo_Exceptions)**

Vous pouvez chercher les TODO pour trouver les explications importantes.

Lorsqu'on vous demande de chercher des TODO, vous devez télécharger le **[repo du cours](https://github.com/departement-info-cem/3N5-Prog3/tree/main)** (`Code > Download ZIP`) et retrouver le code dans la hiérarchie (il se trouve sous le répertoire `code`). 

Pour lister les TODO dans IntelliJ : `Menu hamburger en haut à gauche > View > Tool Windows > TODO`.

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
- Continuer le **[premier travail](../tp/tp1)**

:::

</Column>

</Row>

:::note Exercices

Exercices type:
- expliquer un stack trace et suggérer l'étape suivante
- sans ordi prévoir le comportement
- avec ordi et débogueur, répondre à une question creuse
- programmer un bout de code qui illustre la compréhension

### Exercice devine qui va attraper

Fournir un exemple de code 

### Exercice TrouveLaValeur

Vous devez écrire une classe appelée Trouveru. Cette classe doit contenir une méthode statique appelée trouve qui prend en paramètre

- un tableau de String (String[]): la tableau dans lequel on cherche
- un String: l'élément qu'on cherche

La méthode doit avoir le comportement suivant:

- si l'élément est dans le tableau, vous renvoyez l'index de la première cellule où il se trouve
- si l'élément n'est pas dans le tableau, vous lancez une exception. Vous devez définir la classe d'exception dans une classe et choisir un nom d'exception significatif.

Finalement vous devez démontrer le fonctionnement de votre code dans une classe App avec un appel normal (où on trouve l'élément) et un appel exceptionnel (qui lance l'exception).

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

### Exercice sans machine 👨‍🎤👨‍💼

Sans exécuter, selon toi est-ce que les 2 méthodes suivantes donnent le même résultat ou non?

Crée toi un projet pour valider ta réponse si les méthodes sont pareilles ou non.

TODO Comment ils doivent en garder une trace dans leur repo étudiant

```kotlin
public static void lireDesFichiersForTry(){
    for (int i = 0 ; i < 10 ; i++ ){
        try {
            lireFichier(i); 
        } catch (FileNotFoundException e) {
            System.out.println("fichier n'existe pas");
        }
    }
}

public static void lireDesFichiersTryFor(){
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
