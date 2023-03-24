package com.example.examenandroidizder.ui.moduleUser

import com.example.examenandroidizder.database.entity.User
import retrofit2.Callback

interface IUserActivity {

    interface View {
        fun showUsers(users: List<User>)
    }

    interface Presenter {

    }

    interface Model {

    }
}