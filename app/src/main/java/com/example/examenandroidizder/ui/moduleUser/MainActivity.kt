package com.example.examenandroidizder.ui.moduleUser

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import com.example.examenandroidizder.ui.modulePhoto.PhotoActivity
import com.example.examenandroidizder.R
import com.example.examenandroidizder.database.AppDatabase
import com.example.examenandroidizder.database.dao.UserDao
import com.example.examenandroidizder.database.entity.User
import com.example.examenandroidizder.databinding.ActivityMainBinding

open class MainActivity : AppCompatActivity(), IUserActivity.View {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainActivityPresenter
  lateinit var userdao:UserDao

    companion object {
        lateinit var usuName: String
        val emptyByteArray = ByteArray(0)
        var photoObtained = BitmapFactory.decodeByteArray(emptyByteArray, 0, 0)
        var backgroundColor = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MainActivityPresenter(
            this, this,
        )
        presenter.obteniedColor()
        val room = Room.databaseBuilder(this, AppDatabase::class.java, "user").build()

        // Llame a getUsers() para obtener y mostrar usuarios
        presenter.getUsers()

        iniComponent(room)
    }


    private fun saveUser(room: AppDatabase) {

        room.UserDao().updateUser(1, binding.edtUserName.toString())
    }


    private fun iniComponent(room: AppDatabase) {
       // showNameUser(room)
        // Only allow alphanumeric characters
        val filter = InputFilter { source, _, _, _, _, _ ->
            source.filter { it.isLetterOrDigit() }
        }

        binding.edtUserName.filters = arrayOf(filter)


        binding.btnNextView.setOnClickListener {
            validateEditTextEmpty(binding.edtUserName,room)
        }

    }

    private fun showNameUser(room: AppDatabase) {

        var usuario = room.UserDao().getUser(1)
        if (usuario != null) {
            binding.txtNameView.setText(usuario.name)
        }
    }

    //Validation that the edit text is not empty
    private fun validateEditTextEmpty(edtUserName: EditText, room: AppDatabase) {
        if (!edtUserName.text.toString().equals("")) {
            usuName = edtUserName.text.toString()
            startActivity(Intent(this, PhotoActivity::class.java))
         //   saveUser(room)
            //   presenter.addUser(user)
        } else {
            Toast.makeText(this, getString(R.string.msg_validate_usu), Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun showUsers(users: List<User>) {
        TODO("Not yet implemented")
    }

    override fun setColorBackground(color: String) {
        backgroundColor = color
        // Set the background color
        if (!backgroundColor.equals("")) {
            getWindow().getDecorView().setBackgroundColor(Color.parseColor(backgroundColor))
        }
    }


}