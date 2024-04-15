package com.caiosilva.recyclerview2tdspn

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.caiosilva.recyclerview2tdspn.databinding.ItemViewBinding
import com.squareup.picasso.Picasso

class PostagemAdapter : ListAdapter<Photo, PostagemAdapter.MyViewHolder>(DiffCallback()) {

    var onClick: (Photo) -> Unit = {}

    inner class MyViewHolder(val binding: ItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Photo) {
            binding.imageViewAvatar.setImageFromUrl(photo.thumbnailUrl)
            binding.textViewNomeUsuario2.text = photo.id.toString()
            binding.textViewNomeUsuario.text = photo.title
            binding.textViewDescricao.text = photo.url
            binding.imageViewPostagem.setImageFromUrl(photo.thumbnailUrl)

            binding.root.setOnClickListener {
                onClick(photo)
            }
        }
    }

    class DiffCallback() : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemViewBinding.inflate(layoutInflater)
        val myViewHolder = MyViewHolder(binding)

        return myViewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}