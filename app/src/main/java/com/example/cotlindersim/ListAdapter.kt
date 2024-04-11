package com.example.cotlindersim

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cotlindersim.databinding.ListItemBinding

class ListAdapter(private val list: List<ListDataModel>): RecyclerView.Adapter<ListAdapter.MyListViewHolder>() {

    inner class MyListViewHolder(private val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(getList: ListDataModel){
            binding.tvTitle.text = getList.title
            binding.tvDescription.text = getList.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyListViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}
