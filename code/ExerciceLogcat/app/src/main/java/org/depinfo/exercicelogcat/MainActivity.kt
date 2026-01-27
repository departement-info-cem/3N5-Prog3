package org.depinfo.exercicelogcat

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.depinfo.exercicelogcat.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val fileName = "MessagesImportants.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        logcat()
    }

    private fun logcat() {
        var reader: BufferedReader? = null
        try {
            reader = BufferedReader(
                InputStreamReader(assets.open(fileName), "UTF-8")
            )

            var line: String;
            while (reader.readLine().also { line = it } != null) {
                val words: List<String> = line.split("|")
                when (words[1]) {
                    "info" -> Log.i(words[0], words[2])
                    "warn" -> Log.w(words[0], words[2])
                    "error" -> Log.e(words[0], words[2])
                    "debug" -> Log.d(words[0], words[2])
                    "verbose" -> Log.v(words[0], words[2])
                }
            }
        } finally {
            reader?.close()
        }
    }
}