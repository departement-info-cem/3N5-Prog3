package utils

import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CaptureStdOut : PrintStream(buffer) {
    companion object {
        private var parentStdout: PrintStream? = null
        private val buffer = ByteArrayOutputStream()
    }

    val output: String
        get() = buffer.toString()

    fun contains(search: String): Boolean {
        return buffer.toString().contains(search)
    }

    init {
        if (parentStdout == null) {
            buffer.reset()
            parentStdout = System.out
            System.setOut(this)
            System.setErr(this)
        }
    }

    override fun close() {
        super.close()
        if (parentStdout != null) {
            System.setOut(parentStdout)
            parentStdout = null
        }
    }

    @Throws(Exception::class)
    override fun write(b: Int) {
        write(byteArrayOf((b and 0xFF).toByte()))
    }

    override fun write(b: ByteArray, off: Int, len: Int) {
        buffer.write(b, off, len)
        parentStdout?.write(b, off, len)
    }

    override fun flush() {
        parentStdout?.flush()
    }
}