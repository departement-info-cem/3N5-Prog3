package org.depinfo.recetterecyclerviewcontexte

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.depinfo.recetterecyclerviewcontexte.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val monExtra = intent.getStringExtra("monExtra")
        binding.tvMonExtra.text = monExtra
    }
}