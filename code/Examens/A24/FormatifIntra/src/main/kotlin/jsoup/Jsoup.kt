package jsoup

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

fun main() {
    // Tu peux tester la fonction en l'appelant ici.
}

/**
 *  Cette question vise à évaluer ta capacité à lire de la documentation.
 *  Tu devras donc te référer à la documentation officielle de jsoup, qui est disponible ici : https://jsoup.org/
 *
 * La page web `https://info.cegepmontpetit.ca/3N5-Prog3/intraA24-2.html` ne contient rien dans la balise `body`.
 *
 * Pour chaque string de la liste donnée en paramètre, tu dois ajouter une nouvelle div dans la balise `body`,
 * qui contient la string.
 *
 * Une fois que les modifications ont été appliquées, tu dois retourner le document modifié, et imprimer le html modifié
 * dans la console.
 *
 * Pour tester le résultat, tu peux enregistrer le code html dans un fichier, ou simplement copier le code html qui est
 * dans la console, le mettre dans un fichier html, et l'ouvrir dans un navigateur.
 * Tu devrais voir les mots "Comment est votre blanquette?" qui tournent, étalés verticalement, avec un fond bleu.
 *
 * (3 point) Chaque élément demandé est présent dans le document retourné.
 * (1 point) Le contenu de la page html modifiée doit être imprimé dans la console.
 *
 * Exemple du body avant :
 * <body></body>
 *
 * Exemple du body après :
 * <body>
 *     <div>Comment</div>
 *     <div>est</div>
 *     <div>votre</div>
 *     <div>blanquette ?</div>
 * </body>
 */
fun jsoup(mots: List<String>): Document? {
    return null
}