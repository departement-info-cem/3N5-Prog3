# Examen final 3N5 : partie papier

## Layout vers dessin


```kotlin
@Composable
fun Final() {
    Row(modifier = Modifier.fillMaxSize()) {
        Text(
            "yo",
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Red)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(400.dp))
            Button(onClick = {  }, modifier = Modifier.fillMaxWidth()) {
                Text("Ahah !")
            }
            Button(onClick = {  }, modifier = Modifier.fillMaxWidth()) {
                Text("Ohoh !")
            }
        }
    }
}

```

**4 points** Etant donné le fichier fourni, dessine ce à quoi ressemblerait l'interface en mode portrait :

```
































```

## Types des expressions

```kotlin
var a           = 5 + 2 * 2
val b           = a > 88
var c           = a / 2.0f
val d           = a / 5 
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
var liste = mutableListOf<Float>(4.5f, 5.4f)
var liste2 = mutableListOf<String>("plif", "plouf", "plaffe")
for (i in 1..3) {
  for (e in liste2)   {
      liste.add(e.length.toFloat() * 1.5f)
  }
}
```

**2 points** Etant donné ce code en kotlin, indique quels sont les éléments présents dans la liste `liste` à la fin de l'éxécution :

```



```
