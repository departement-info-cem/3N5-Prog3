package cantine

class MauvaisChoixCantineException: Exception() {
    override val message: String?
        get() = "Désolé, ce choix n'est pas disponible."
}