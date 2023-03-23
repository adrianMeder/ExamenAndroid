package com.example.examenandroidizder.ui.moduleShowPhotoActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.examenandroidizder.databinding.ActivityMainBinding
import com.example.examenandroidizder.databinding.LayoutShowPhotoBinding
import com.example.examenandroidizder.ui.moduleUser.MainActivity

class ShowPhotoActivity : AppCompatActivity() {
    private lateinit var binding: LayoutShowPhotoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutShowPhotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        iniComponent()
    }

    private fun iniComponent() {
            binding.imgPhoto.setImageBitmap(MainActivity.photoObtained)
    }
}
