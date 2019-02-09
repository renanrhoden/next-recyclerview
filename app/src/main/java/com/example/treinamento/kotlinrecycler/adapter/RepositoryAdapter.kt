package com.example.treinamento.kotlinrecycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.treinamento.kotlinrecycler.R
import com.example.treinamento.kotlinrecycler.api.Repository
import kotlinx.android.synthetic.main.repository_item.view.*

class RepositoryAdapter(
    private val items: List<Repository>,
    private val context: Context,
    private val listener: (Repository) -> Unit
) : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            inflater.inflate(
                R.layout.repository_item,
                parent,
                false
            )
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Repository, listener: (Repository) -> Unit) = with(itemView) {
//            ivMain.setImageDrawable(ContextCompat.getDrawable(context, item.imageResourceId))
            tvTitle.text = item.name
            owner.text = item.owner?.login
            tvDescription.text = item.description

            Glide.with(ivMain)
                .load(item.owner?.avatar_url)
                .into(ivMain)

            setOnClickListener {
                listener(item)
            }
        }
    }
}