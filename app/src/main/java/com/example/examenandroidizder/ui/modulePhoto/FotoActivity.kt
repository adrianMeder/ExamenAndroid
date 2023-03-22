package com.example.examenandroidizder.ui.modulePhoto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.examenandroidizder.databinding.ActivityMainBinding
import com.example.examenandroidizder.databinding.LayoutActivityFotoBinding

class FotoActivity : AppCompatActivity() {
    private lateinit var binding: LayoutActivityFotoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutActivityFotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        iniComponent()
    }

    private fun iniComponent() {

    }
}