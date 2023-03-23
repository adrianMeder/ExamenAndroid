package com.example.examenandroidizder.ui.modulePhoto

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.result.ActivityResultLauncher

class PhotoActivityPresenter(
    private val view: IPhoto.View, private val activity: Activity,
    private val context: Context,
) : IPhoto.Presenter {

    private val model = PhotoActivityModel(this, context)

    fun onCameraButtonClicked() {
        view.showCamera()
    }

    fun onPhotoTaken(photo: Bitmap) {
        view.showPhoto(photo)
    }

    fun onError(errorMessage: String) {
        view.showErrorMessage(errorMessage)
    }

    override fun onButtonClicked(selectPDFFile: ActivityResultLauncher<String>) {

    }

    override fun onFileSelected(fileUri: Uri) {

    }

}