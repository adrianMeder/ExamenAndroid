package com.example.examenandroidizder.ui.moduleUser

import android.content.Context
import com.example.examenandroidizder.data.UserRepository
import com.example.examenandroidizder.database.entity.User

class MainActivityPresenter(private val view: IUserActivity.View ,var context :Context):IUserActivity.Presenter {

    private val model = MainActivityModel(this, context)

    override fun obteniedColor() {
        model.obtainColor()
    }

    override fun setColorBackground(color: String) {
        view.setColorBackground(color)
    }
}