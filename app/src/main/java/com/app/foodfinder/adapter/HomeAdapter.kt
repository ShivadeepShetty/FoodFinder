package com.app.foodfinder.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.foodfinder.databinding.ItemSearchResultBinding
import com.app.foodfinder.dto.RestItemDetails

class HomeAdapter  : RecyclerView.Adapter<HomeAdapter.ViewHolder>(){

    private var items:MutableList<RestItemDetails> = mutableListOf()

    class ViewHolder(private val itemBinding: ItemSearchResultBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bindItems(data: RestItemDetails) {
            itemBinding.id.text = data.id
            itemBinding.name.text = data.name

        }
    }

    fun submitData(data:MutableList<RestItemDetails>){
        items = data
        notifyDataSetChanged()
    }
    fun clearData(){
        items.clear()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ItemSearchResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(
            itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = items[position]

        if (currentItem != null) {
            holder.bindItems(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}