package com.example.cotlindersim

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cotlindersim.databinding.ListItemBinding

class ListAdapter(private val list: MutableList<ListDataModel>): RecyclerView.Adapter<ListAdapter.MyListViewHolder>() {

    inner class MyListViewHolder(private val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(getList: ListDataModel){
            binding.tvTitle.text = getList.title
            binding.tvDescription.text = getList.description
            binding.ivDelete.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    list.removeAt(position)
                    notifyItemRemoved(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyListViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
