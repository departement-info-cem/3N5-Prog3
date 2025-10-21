# Partie papier

## Layout vers dessin

```kotlin
@Composable
fun ExamenFinal() {
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { }, modifier = Modifier.fillMaxWidth()) 
        { Text("Popopo !") }
        Spacer(modifier = Modifier.weight(1f))
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(200.dp)
                    .background(Color.Blue)
            ) { }
            Text(
                text = "Plop plop plop",
                modifier = Modifier
                    .weight(2f)
                    .padding(8.dp)
            )
        }
    }
}
```


**4 points** Etant donné le fichier fourni, dessine ce à quoi ressemblerait l'interface en mode portrait :

```






























```

## Types des expressions

```kotlin
var a           = 11 * 2
val b           = a > 20
var c           = a * 3.0f
val d           = "examen " + a.toString()
```

**4 points** Dans le code fourni, indique les types et valeurs de chaque val var :

```
a valeur :                     type :
b valeur :                     type :
c valeur :                     type :
d valeur :                     type :
```

## Code vers liste

```kotlin
var liste = mutableListOf<String>("x", "y", "z")
var liste2 = mutableListOf<String>("a", "bcd", "e")
for (i in 1..2) {
  liste2.addAll(liste)
}
```

**2 points** Etant donné ce code en kotlin, indique quels sont les éléments présents dans la liste `liste2` à la fin de l'éxécution :

```



```

---