package trycatch

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.net.MalformedURLException
import java.net.UnknownHostException

fun main(args: Array<String>) {

    println("Bienvenu dans le programme de lecture d'url!")

    try {
        val htmlLu: String = lireUrlTryCatch2(args[0])
        println(htmlLu)
    } catch (e: UnknownHostException) {
        println("Aucun site web n'existe à cette adresse")
    } catch (e: MalformedURLException) {
        println("L'URL fournie est mal formée")
    }

    println("Au revoir!")
}

fun lireUrlTryCatch2(url: String): String {
    val connection: Document = Jsoup.connect(url).get()
    return connection.html()
}