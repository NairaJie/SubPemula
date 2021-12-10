package com.nailah.subpemula.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nailah.subpemula.data.Heli
import com.nailah.subpemula.databinding.ItemListBinding

class HeliAdapter(private val listDataHeli: ArrayList<Heli>) :
    RecyclerView.Adapter<HeliAdapter.HeliViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallBack

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallBack) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallBack {
        fun onItemClicked(heli: Heli)
    }

    inner class HeliViewHolder(var heliBinding: ItemListBinding) :
        RecyclerView.ViewHolder(heliBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeliViewHolder {
        val heliBinding =
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeliViewHolder(heliBinding)
    }

    override fun getItemCount(): Int = listDataHeli.size

    override fun onBindViewHolder(holder: HeliViewHolder, position: Int) {
        val heli = listDataHeli[position]

        Glide.with(holder.itemView.context).load(heli.image)
            .into(holder.heliBinding.ivItem)
        holder.heliBinding.tvNameItem.text = heli.name
        holder.heliBinding.tvPriceItem.text = heli.price
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listDataHeli[holder.adapterPosition])
        }
    }
}