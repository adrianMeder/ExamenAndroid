package com.example.examenandroidizder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import com.example.examenandroidizder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        iniComponent()
    }

    private fun iniComponent() {

        val filter = InputFilter { source, _, _, _, _, _ ->
            // Only allow alphanumeric characters
            source.filter { it.isLetterOrDigit() }
        }

        binding.edtUserName.filters = arrayOf(filter)
    }
}