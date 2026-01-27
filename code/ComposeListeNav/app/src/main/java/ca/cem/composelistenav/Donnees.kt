package ca.cem.composelistenav

// creer une data class avec un id et un nom
data class Donnee(
    val id: Int,
    val nom: String
)

fun donnees() : List<Donnee> = listOf(
    Donnee(1, "Homer Simpson"),
    Donnee(2, "Marge Simpson"),
    Donnee(3, "Bart Simpson"),
    Donnee(4, "Lisa Simpson"),
    Donnee(5, "Maggie Simpson"),
    Donnee(6, "Abraham Simpson"),
    Donnee(7, "Mona Simpson"),
    Donnee(8, "Patty Bouvier"),
    Donnee(9, "Selma Bouvier"),
    Donnee(10, "Ned Flanders"),
    Donnee(11, "Maude Flanders"),
    Donnee(12, "Rod Flanders"),
    Donnee(13, "Todd Flanders"),
    Donnee(14, "Milhouse Van Houten"),
    Donnee(15, "Nelson Muntz"),
    Donnee(16, "Ralph Wiggum"),
    Donnee(17, "Chief Wiggum"),
    Donnee(18, "Apu Nahasapeemapetilon"),
    Donnee(19, "Manjula Nahasapeemapetilon"),
    Donnee(20, "Seymour Skinner"),
    Donnee(21, "Edna Krabappel"),
    Donnee(22, "Groundskeeper Willie"),
    Donnee(23, "Martin Prince"),
    Donnee(24, "Sherri"),
    Donnee(25, "Terri"),
    Donnee(26, "Sideshow Bob"),
    Donnee(27, "Sideshow Mel"),
    Donnee(28, "Krusty le Clown"),
    Donnee(29, "Barney Gumble"),
    Donnee(30, "Moe Szyslak"),
    Donnee(31, "Carl Carlson"),
    Donnee(32, "Lenny Leonard"),
    Donnee(33, "Waylon Smithers"),
    Donnee(34, "Charles Montgomery Burns"),
    Donnee(35, "Itchy"),
    Donnee(36, "Scratchy"),
    Donnee(37, "Comic Book Guy"),
    Donnee(38, "Reverend Lovejoy"),
    Donnee(39, "Helen Lovejoy"),
    Donnee(40, "Dr. Hibbert"),
    Donnee(41, "Dr. Nick Riviera"),
    Donnee(42, "Kent Brockman"),
    Donnee(43, "Troy McClure"),
    Donnee(44, "Lionel Hutz"),
    Donnee(45, "Judge Snyder"),
    Donnee(46, "Mayor Quimby"),
    Donnee(47, "Clancy Wiggum"),
    Donnee(48, "Lou"),
    Donnee(49, "Eddie"),
    Donnee(50, "Snake Jailbird")
)

fun donnee(id : Int) : Donnee {
    return donnees().firstOrNull { it.id == id } ?: Donnee(0, "Inconnu")
}
