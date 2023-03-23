package com.example.examenandroidizder.ui.modulePhoto

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.result.ActivityResultLauncher

interface IPhoto {
    interface View {
        fun showPhoto(photo: Bitmap)
        fun showCamera()
        fun showErrorMessage(message: String)
    }
    interface Presenter {
        fun onButtonClicked(selectPDFFile: ActivityResultLauncher<String>)
        fun onFileSelected(fileUri: Uri)
    }

    interface Model {}
}