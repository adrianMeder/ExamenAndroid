package com.example.examenandroidizder.ui.modulePhoto

import android.app.ProgressDialog.show
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior.getTag
import com.example.examenandroidizder.R
import com.example.examenandroidizder.databinding.ActivityMainBinding
import com.example.examenandroidizder.databinding.LayoutActivityFotoBinding
import com.example.examenandroidizder.ui.genericDialog.DialogGenericParm
import com.example.examenandroidizder.ui.genericDialog.EnumDialog

class FotoActivity : AppCompatActivity() {
    private lateinit var binding: LayoutActivityFotoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutActivityFotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        iniComponent()
    }

    private fun iniComponent() {
        binding.btnOpenModal.setOnClickListener {
            mostrarModal()
        }
    }

    fun mostrarModal() {
      var  bottomSheetNuevoModal = DialogGenericParm(getString(R.string.txt_menu_photo),
        getString(R.string.txt_menu_photo_sub), EnumDialog.DEFAULT)
        val fm = this!!.supportFragmentManager
       // DialogGenericParm.show(fm, DialogGenericParm.getag())
    }
}