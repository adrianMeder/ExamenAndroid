package com.example.examenandroidizder.ui.moduleUser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.widget.EditText
import android.widget.Toast
import com.example.examenandroidizder.ui.modulePhoto.FotoActivity
import com.example.examenandroidizder.R
import com.example.examenandroidizder.databinding.ActivityMainBinding

open class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        iniComponent()
    }

    
    private fun iniComponent() {
        // Only allow alphanumeric characters
        val filter = InputFilter { source, _, _, _, _, _ ->
            source.filter { it.isLetterOrDigit() }
        }

        binding.edtUserName.filters = arrayOf(filter)


        binding.btnNextView.setOnClickListener {
            validateEditTextEmpty(binding.edtUserName)
        }

    }
    //Validation that the edit text is not empty
    private fun validateEditTextEmpty(edtUserName: EditText) {
        if (!edtUserName.text.toString().equals("")) {
            startActivity(Intent(this, FotoActivity::class.java))
        } else {
            Toast.makeText(this, getString(R.string.msg_validate_usu), Toast.LENGTH_SHORT)
                .show()
        }
    }


}