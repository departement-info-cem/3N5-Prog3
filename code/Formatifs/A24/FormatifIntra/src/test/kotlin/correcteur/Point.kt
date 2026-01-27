package correcteur

class Point(
    val question: String,
    val ponderation: Int,
    var pointsObtenus: Int = 0,
    var explications: MutableList<String> = mutableListOf()
)
