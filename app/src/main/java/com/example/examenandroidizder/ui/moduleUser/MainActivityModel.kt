package com.example.examenandroidizder.ui.moduleUser

import android.content.Context
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivityModel(
    private val presenter: IUserActivity.Presenter,
    private val context: Context,
) : IUserActivity.Model {

    var database = FirebaseDatabase.getInstance().reference
    override fun obtainColor() {
        database.child("colorFondo").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val colorFondo = snapshot.value.toString()
                presenter.setColorBackground(colorFondo)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("TAG", "Error al leer el valor.", error.toException())
            }
        })

    }


}