package com.caiosilva.recyclerview2tdspn

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.caiosilva.recyclerview2tdspn.databinding.ItemViewBinding
import com.squareup.picasso.Picasso

class PostagemAdapter : ListAdapter<Postagem, PostagemAdapter.MyViewHolder>(DiffCallback()) {

    var onClick: (Postagem) -> Unit = {}

    inner class MyViewHolder(val binding: ItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(postagem: Postagem) {
            binding.imageViewAvatar.setImageFromUrl(postagem.avatar)
            binding.textViewNomeUsuario2.text = postagem.nomeUsuario
            binding.textViewNomeUsuario.text = postagem.nomeUsuario
            binding.textViewDescricao.text = postagem.descricao
            binding.imageViewPostagem.setImageFromUrl(postagem.postagem)

            binding.root.setOnClickListener {
                onClick(postagem)
            }
        }
    }

    class DiffCallback() : DiffUtil.ItemCallback<Postagem>() {
        override fun areItemsTheSame(oldItem: Postagem, newItem: Postagem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Postagem, newItem: Postagem): Boolean {
            return oldItem.descricao == newItem.descricao
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