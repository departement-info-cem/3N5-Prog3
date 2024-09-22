package correcteur

import org.opentest4j.AssertionFailedError

fun testeur(
    point: Point, pointsAjoutesSiReussi: Int, pointsRetiresSiEchoue: Int, explicationSiEchoue: String, test: () -> Unit
) {
    try {
        test()
        point.pointsObtenus += pointsAjoutesSiReussi
    } catch (err: AssertionFailedError) {
        point.pointsObtenus -= pointsRetiresSiEchoue
        point.explications += explicationSiEchoue
        throw err
    } catch (err: Exception) {
        point.explications.add("La fonction échoue.")
        throw err
    }
}