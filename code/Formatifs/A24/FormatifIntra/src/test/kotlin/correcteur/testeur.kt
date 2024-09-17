package correcteur

import org.opentest4j.AssertionFailedError

fun testeur(
    point: Point, pointsAjoutesSiReussi: Int, pointsRetiresSiEchoue: Int, explicationSiEchoue: String, test: () -> Unit
): Point {
    try {
        test()
        point.pointsObtenus += pointsAjoutesSiReussi
    } catch (_: AssertionFailedError) {
        point.pointsObtenus -= pointsRetiresSiEchoue
        point.explications += explicationSiEchoue
        return point
    } catch (_: Exception) {
        point.explications.add("La fonction échoue.")
        return point
    }

    return point
}