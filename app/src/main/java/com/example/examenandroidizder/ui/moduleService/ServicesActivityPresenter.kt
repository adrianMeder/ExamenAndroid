package com.example.examenandroidizder.ui.moduleService

import retrofit2.Callback

class ServicesActivityPresenter:IServices.Model {
    override fun fetchData(callback: Callback<String>) {
        // Aquí se realiza la llamada al servicio
        // utilizando Retrofit u otro cliente HTTP
        // y se llama al callback con la respuesta
       // callback.onResponse("https://d4qo4rsz5l.execute-api.us-east-1.amazonaws.com/dev/album/list")
    }
}