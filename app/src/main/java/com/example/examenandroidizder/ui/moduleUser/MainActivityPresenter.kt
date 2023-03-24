package com.example.examenandroidizder.ui.moduleUser

import com.example.examenandroidizder.data.UserRepository
import com.example.examenandroidizder.database.entity.User

class MainActivityPresenter(private val view: IUserActivity.View ,private val userRepository: UserRepository):IUserActivity {


    fun getUsers() {
    //    val users = userRepository.getAllUsers()
     //   view.showUsers(users)
    }

    fun addUser(user:User){
     //   val users = userRepository.addUser(user)
    }
}