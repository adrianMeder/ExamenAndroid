package com.example.examenandroidizder.ui.moduleService.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.examenandroidizder.R
import com.example.examenandroidizder.database.entity.Disk
import com.example.examenandroidizder.databinding.ItemDiskBinding
import com.example.examenandroidizder.ui.moduleService.interfaces.OnClickListener

class AdapterService(private var context: Context, private var listener: OnClickListener) :
    RecyclerView.Adapter<AdapterService.ViewHolder>() {
    private var listaDisk = mutableListOf<Disk>()

    fun setListData(data: MutableList<Disk>) {
        listaDisk = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_disk, parent, false)
        return ViewHolder(view)
    }
    fun loadImageFromUrl(url: String, imageView: ImageView) {
        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listaDiskPos = listaDisk.get(position)
        with(holder) {
            setListener(listaDiskPos)

            binding.txtAlbumName.setText(listaDiskPos.albumName)
            binding.txtNameArtist.setText(listaDiskPos.artistName)
            binding.txtDate.setText(listaDiskPos.releaseDate.toString())
            binding.txtDuration.setText(listaDiskPos.duration)
            loadImageFromUrl(listaDiskPos.img, binding.imgPhoto)
        }
    }


    override fun getItemCount(): Int {
        return listaDisk.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemDiskBinding.bind(view)
        fun setListener(disk: Disk) {

        }
    }
}