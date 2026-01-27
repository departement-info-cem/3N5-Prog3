package ca.cem

import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader

fun main(args: Array<String>) {
    lireDesFichiersJimmy()
    lireDesFichiersJohnny()
}

fun lireDesFichiersJimmy() {
    for (i in 0 until 10) {
        try {
            lireFichier(i)
            println("fichier $i lu par Jimmy")
        } catch (e: FileNotFoundException) {
            println("fichier $i n'existe pas Jimmy")
        }
    }
}

fun lireDesFichiersJohnny() {
    var cpt = 0
    try {
        for (i in 0 until 10) {
            lireFichier(i)
            cpt = i
            println("fichier $i lu par Johnny")
        }
    } catch (e: FileNotFoundException) {
        println("fichier $cpt n'existe pas Johnny")
    }
}

@Throws(FileNotFoundException::class)
fun lireFichier(i: Int) {
    val f = File("files/toto$i.txt")
    val fr = FileReader(f)
    // println("J'ai 'lu' le fichier $i")
}
