package com.example.examenandroidizder.ui.moduleService

import android.app.Activity
import android.content.Context
import com.example.examenandroidizder.database.entity.Disk
import com.example.examenandroidizder.ui.moduleService.interfaces.IServices
import retrofit2.Callback

class ServicesActivityPresenter(private val view: IServices.View, private val activity: Activity,
                                private val context: Context,): IServices.Presenter {

    private val model = ServicesActivityModel(this, context)

    var listaDisk: MutableList<Disk> = mutableListOf()
     fun fetchData(callback: Callback<String>) {
        // Aquí se realiza la llamada al servicio
        // utilizando Retrofit u otro cliente HTTP
        // y se llama al callback con la respuesta
       // callback.onResponse("https://d4qo4rsz5l.execute-api.us-east-1.amazonaws.com/dev/album/list")
    }

    fun returnListDisk(){
        model.listaDisk
    }

    override fun getData() {
        TODO("Not yet implemented")
    }


    override fun loadList() {
       model.loadList()
    }

    override fun SetListDisk(mutableListDisk: MutableList<Disk>) {
       view.SetListDisk(mutableListDisk)
    }


}