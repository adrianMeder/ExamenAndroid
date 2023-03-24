package com.example.examenandroidizder.ui.moduleService.interfaces

import com.example.examenandroidizder.database.entity.Disk
import retrofit2.Callback

interface IServices {
    interface View {
        fun showData(data: String)
        fun showError(error: String)

        fun SetListDisk(mutableListDisk: MutableList<Disk>)
    }

    interface Presenter {
        fun getData()

        fun loadList()
        fun SetListDisk(mutableListDisk: MutableList<Disk>)
    }

    interface Model {
        fun fetchData(callback: Callback<String>)
        fun loadList()
    }
}