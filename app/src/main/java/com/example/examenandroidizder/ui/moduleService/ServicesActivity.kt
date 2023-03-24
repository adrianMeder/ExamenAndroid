package com.example.examenandroidizder.ui.moduleService

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.examenandroidizder.database.entity.Disk
import com.example.examenandroidizder.databinding.LayoutListServicesBinding
import com.example.examenandroidizder.ui.moduleService.adapter.AdapterService
import com.example.examenandroidizder.ui.moduleService.interfaces.OnClickListener
import com.example.examenandroidizder.ui.moduleService.interfaces.IServices

class ServicesActivity : AppCompatActivity(), IServices.View,OnClickListener {

    private lateinit var binding: LayoutListServicesBinding
    private lateinit var presenter: ServicesActivityPresenter
    private lateinit var mAdapter: AdapterService
    private lateinit var mGridLayout: GridLayoutManager
    private var listaDiskNew = mutableListOf<Disk>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutListServicesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = ServicesActivityPresenter(this,
           this,this)
        presenter.returnListDisk()
        presenter.loadList()
        mAdapter = AdapterService(this,this )
        setReciclerViewWeekFilter()
        iniComponent()
    }

    private fun iniComponent() {
        //Set the adapter to recycler and separate the list into a 2-item grid

    }

    private fun setReciclerViewWeekFilter() {
        mGridLayout = GridLayoutManager(this, 1)
        binding.rcvServices?.apply {
            setHasFixedSize(true)
            layoutManager = mGridLayout
            adapter = mAdapter
        }
        mAdapter.setListData(listaDiskNew)
        mAdapter.notifyDataSetChanged()
        //    observeData()
    }
    override fun showData(data: String) {
        TODO("Not yet implemented")
    }

    override fun showError(error: String) {
        TODO("Not yet implemented")
    }

    override fun SetListDisk(mutableListDisk: MutableList<Disk>) {
        listaDiskNew=mutableListDisk
    }

    override fun onClick(disco: Disk) {
        TODO("Not yet implemented")
    }
}