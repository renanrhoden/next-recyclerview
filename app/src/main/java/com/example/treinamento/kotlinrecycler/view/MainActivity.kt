package com.example.treinamento.kotlinrecycler.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.treinamento.kotlinrecycler.R
import com.example.treinamento.kotlinrecycler.adapter.ProgrammingLanguageAdapter
import com.example.treinamento.kotlinrecycler.model.ProgrammingLanguage
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = ProgrammingLanguageAdapter(
            recyclerViewItems(),
            this
        ) {
            longToast("Clicked item : ${it.title}")
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun recyclerViewItems(): List<ProgrammingLanguage> {
        val kotlin = ProgrammingLanguage(
            R.drawable.kotlin,
            "Kotlin",
            2010,
            "Kotlin description"
        )

        return listOf(kotlin, kotlin)
    }
}


