package com.example.examenandroidizder.ui.modulePhoto

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.examenandroidizder.R
import com.example.examenandroidizder.databinding.LayoutActivityFotoBinding
import com.example.examenandroidizder.ui.genericDialog.DialogGenericModal
import com.example.examenandroidizder.ui.genericDialog.EnumDialog
import com.example.examenandroidizder.ui.genericDialog.IDialogModalInterface
import com.example.examenandroidizder.ui.moduleShowPhotoActivity.ShowPhotoActivity
import com.example.examenandroidizder.ui.moduleUser.MainActivity
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.ByteArrayOutputStream

class PhotoActivity : AppCompatActivity(), IDialogModalInterface, IPhoto.View {

    private lateinit var binding: LayoutActivityFotoBinding
    private lateinit var bottomSheetDialog: DialogGenericModal
    private lateinit var IDialogModal: IDialogModalInterface
    private lateinit var presenter: PhotoActivityPresenter
    private lateinit var mStorage: FirebaseStorage
    val myRef = Firebase.database.getReference("file")

    companion object {
        const val REQUEST_CODE_CAMERA = 200
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutActivityFotoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = PhotoActivityPresenter(this, this, this)
        mStorage = FirebaseStorage.getInstance()
        iniComponent()
    }

    private fun iniComponent() {
        presenter.permissionStorage()
        binding.progressBar.visibility = View.GONE
        IDialogModal = this
        binding.btnOpenModal.setOnClickListener {
            mostrarModal()
        }

        binding.btnSaveStorage.setOnClickListener {

            if (MainActivity.photoObtained != null) {
                uploadPhotosStorage(MainActivity.photoObtained)
            } else {
                Toast.makeText(this, getString(R.string.msg_photo_control_storage), Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    //Show modal
    fun mostrarModal() {
        bottomSheetDialog = DialogGenericModal(getString(R.string.txt_menu_photo),
            getString(R.string.txt_menu_photo_sub), EnumDialog.MODALPHOTO, IDialogModal)
        val fm = this.supportFragmentManager
        bottomSheetDialog.show(fm, bottomSheetDialog.tag)
    }

    //Button chosen to take photo
    override fun dialogTakePhoto() {
        checkCameraPermission()
    }

    //Chosen button to show photo
    override fun dialogViewPhoto() {
        if (MainActivity.photoObtained != null) {
            startActivity(Intent(this, ShowPhotoActivity::class.java))
        } else {
            Toast.makeText(this, getString(R.string.msg_photo_control), Toast.LENGTH_SHORT).show()
        }
    }


    //Permission camera
    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED
        ) {
            //The permission is not accepted.
            requestCameraPermission()
        } else {
            //The permission is accepted.
            presenter.onCameraButtonClicked()
        }
    }


    //Permission check
    private fun requestCameraPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.CAMERA)
        ) {
            //The user has already refused the permission before, we must inform him to go to settings.
            Toast.makeText(this, getString(R.string.msg_invalid_permission), Toast.LENGTH_SHORT)
                .show()
        } else {
            //The user has never accepted or declined, so we ask him to accept the permission.
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.CAMERA),
                REQUEST_CODE_CAMERA)
        }
    }

    //Gets the obtained image and converts it to bitmap
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {

                REQUEST_CODE_CAMERA -> {//Camera
                    val bitmap = data?.extras?.get("data") as Bitmap
                    presenter.onPhotoTaken(bitmap)
                    //upload Photos to Storage
                    Toast.makeText(this, getString(R.string.save_getting_photo), Toast.LENGTH_SHORT)
                        .show()
                    //   uploadPhotosStorage(bitmap)
                }
            }
        } else {
            presenter.onError(getString(R.string.error_getting_image))
        }

    }

    override fun showPhoto(photo: Bitmap) {
        MainActivity.photoObtained = photo
    }

    // Open the camera to take a photo
    override fun showCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, REQUEST_CODE_CAMERA)
    }

    override fun showErrorMessage(message: String) {
        TODO("Not yet implemented")
    }

    //upload Photos to Storage
    fun uploadPhotosStorage(bitmap: Bitmap) {
        binding.progressBar.visibility = View.VISIBLE
        val bytes = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        val values = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, "nombre_imagen.jpg")
            put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
            put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
        }

        val resolver = this.contentResolver
        val uriImg: Uri? = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)

        uriImg?.let {
            val outputStream = resolver.openOutputStream(uriImg)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)
            outputStream?.close()
        }
        val storageRef = mStorage.reference.child("image")
        val fileName: StorageReference =
            storageRef.child("img-" + uriImg?.lastPathSegment + System.currentTimeMillis() + ".jpg")
        if (uriImg != null) {
            fileName.putFile(uriImg).addOnSuccessListener { uri ->
                val hashMap = HashMap<String, String>()
                hashMap["link"] = java.lang.String.valueOf(uri)
                myRef.setValue(hashMap)
                Toast.makeText(this,
                    getString(R.string.msg_photo_succes),
                    Toast.LENGTH_SHORT).show()
                binding.progressBar.visibility = View.GONE
            }
        }
    }

}