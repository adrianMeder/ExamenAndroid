package com.example.examenandroidizder.ui.moduleService

import retrofit2.Callback

interface IServices {
    interface View {
        fun showData(data: String)
        fun showError(error: String)
    }

    interface Presenter {
        fun getData()
    }

    interface Model {
        fun fetchData(callback: Callback<String>)
    }
}