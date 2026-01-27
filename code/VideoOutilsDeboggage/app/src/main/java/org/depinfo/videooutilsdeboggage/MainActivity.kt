package org.depinfo.videooutilsdeboggage

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import org.depinfo.videooutilsdeboggage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBtn1()
        setupBtn2()

        bouclePasSiComplique()
    }

    private fun setupBtn1() {
        binding.btn1.setOnClickListener {
            Snackbar.make(binding.root, "Bouton 1 appuyé", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun setupBtn2() {
        binding.btn2.setOnClickListener {
            Snackbar.make(binding.root, "Bouton 2 appuyé", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun bouclePasSiComplique() {
        for (i in 1..1000) {
            val x = i
            val y = 1000 / i
            Log.i("MON_SUPER_LOG", "x = $x, y = $y")
            Log.e("UN_AUTRE_LOG", "a = $x, b = $y")
        }
    }
}