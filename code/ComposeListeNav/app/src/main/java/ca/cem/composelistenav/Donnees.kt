package ca.cem.composelistenav

// creer une data class avec un id et un nom
data class Donnee(
    val id: Int,
    val nom: String
)

fun donnees() : List<Donnee> = listOf(
    Donnee(1, "Item 1"),
    Donnee(2, "Item 2"),
    Donnee(3, "Item 3"),
    Donnee(4, "Item 4"),
    Donnee(5, "Item 5"),
    Donnee(6, "Item 6"),
    Donnee(7, "Item 7"),
    Donnee(8, "Item 8"),
    Donnee(9, "Item 9"),
    Donnee(10, "Item 10")
)

fun donnee(id : Int) : Donnee {
    return donnees().firstOrNull { it.id == id } ?: Donnee(0, "Inconnu")
}
