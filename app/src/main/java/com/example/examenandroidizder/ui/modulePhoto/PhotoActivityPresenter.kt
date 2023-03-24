package com.example.examenandroidizder.ui.modulePhoto

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.result.ActivityResultLauncher
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

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

    override fun permissionStorage() {
        val permission = Manifest.permission.READ_EXTERNAL_STORAGE
        val grant = ContextCompat.checkSelfPermission(context, permission)
        if (grant != PackageManager.PERMISSION_GRANTED) {
            val permissionList = arrayOf(permission)
            ActivityCompat.requestPermissions(activity, permissionList, 1)
        }
    }

    override fun onButtonClicked(selectPDFFile: ActivityResultLauncher<String>) {

    }

    override fun onFileSelected(fileUri: Uri) {

    }

}