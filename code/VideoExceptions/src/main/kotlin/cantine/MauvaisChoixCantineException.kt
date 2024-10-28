package cantine

import java.lang.Exception

class MauvaisChoixCantineException: Exception() {
    override val message: String?
        get() = "Choix invalide!"
}