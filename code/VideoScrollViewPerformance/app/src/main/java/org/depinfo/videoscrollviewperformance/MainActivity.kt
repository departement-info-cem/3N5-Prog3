
package org.depinfo.videoscrollviewperformance

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.depinfo.videoscrollviewperformance.databinding.ActivityMainBinding
import org.depinfo.videoscrollviewperformance.databinding.DemoItemBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupItems()
    }

    private fun setupItems() {
        for (i in 0..1000) {
            val dynamicItemBinding = DemoItemBinding.inflate(layoutInflater)
            dynamicItemBinding.tvItem.text = "Item $i"
            binding.llDynamic.addView(dynamicItemBinding.root)
        }
    }
}