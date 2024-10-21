package org.depinfo.testsexercice1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.depinfo.testsexercice1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Voir les tests ;)
    }
}