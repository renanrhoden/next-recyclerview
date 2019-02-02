package com.example.treinamento.kotlinrecycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.treinamento.kotlinrecycler.R
import com.example.treinamento.kotlinrecycler.model.ProgrammingLanguage
import kotlinx.android.synthetic.main.programming_language_item.view.*

class ProgrammingLanguageAdapter(
    private val items: List<ProgrammingLanguage>,
    private val context: Context,
    private val listener: (ProgrammingLanguage) -> Unit
) : RecyclerView.Adapter<ProgrammingLanguageAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            inflater.inflate(
                R.layout.programming_language_item,
                parent,
                false
            )
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: ProgrammingLanguage, listener: (ProgrammingLanguage) -> Unit) = with(itemView) {
            ivMain.setImageDrawable(ContextCompat.getDrawable(context, item.imageResourceId))
            tvLaunchYear.text = item.year.toString()
            tvDescription.text = item.description

            setOnClickListener {
                listener(item)
            }
        }
    }
}