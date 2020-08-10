package com.github.livingwithhippos.androidtemplate.start.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.livingwithhippos.androidtemplate.databinding.ItemJobBinding
import com.github.livingwithhippos.androidtemplate.model.network.api.Position

class PositionAdapter : ListAdapter<Position, PositionAdapter.PositionViewHolder> (Companion) {

    class PositionViewHolder(val binding: ItemJobBinding) : RecyclerView.ViewHolder(binding.root)

    companion object: DiffUtil.ItemCallback<Position>() {
        override fun areItemsTheSame(oldItem: Position, newItem: Position): Boolean = oldItem === newItem
        //todo: check more contents
        override fun areContentsTheSame(oldItem: Position, newItem: Position): Boolean = oldItem.id == newItem.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PositionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemJobBinding.inflate(layoutInflater)

        return PositionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PositionViewHolder, position: Int) {
        val currentPosition = getItem(position)
        holder.binding.position = currentPosition
        holder.binding.executePendingBindings()
    }
}