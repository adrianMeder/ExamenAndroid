package com.example.examenandroidizder.ui.moduleService

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.examenandroidizder.database.entity.Disk
import com.example.examenandroidizder.ui.moduleService.interfaces.IServices
import retrofit2.Callback
import java.text.SimpleDateFormat
import java.util.*

class ServicesActivityModel(
    private val presenter: IServices.Presenter, private val context: Context, ) : IServices.Model {
    val listaDisk: MutableList<Disk> = mutableListOf()

    override fun fetchData(callback: Callback<String>) {
        TODO("Not yet implemented")
    }



    //I get the list of Disk
  override  fun loadList() {
        if (listaDisk.size == 0) {

            val fechaDesdeString = SimpleDateFormat("dd/MM/yyyy").parse("20/11/2021")
            var listDisk1 = Disk(1,
                "https://firebasestorage.googleapis.com/v0/b/trader-dev-324821.appspot.com/o/Assets%2Fbeyonce.png?alt=media&token=32ff96e6-3693-4ce6-8d90-1a416f705985",
                "Renaissance",
                "Beyonce",
                fechaDesdeString,
                "01:02")

            val fechaDesdeString2 = SimpleDateFormat("dd/MM/yyyy").parse("16/06/2022")
            var listDisk2 = Disk(2,
                "https://firebasestorage.googleapis.com/v0/b/trader-dev-324821.appspot.com/o/Assets%2Fcoso.png?alt=media&token=35c448fd-4ae3-492f-b808-1db9132e480d",
                "Un verano sin ti",
                "Bad Bunny",
                fechaDesdeString2,
                "01:22")

            listaDisk.add(listDisk1)
            listaDisk.add(listDisk2)
        }
        presenter.SetListDisk(listaDisk)

    }
}