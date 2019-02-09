package com.example.treinamento.kotlinrecycler.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.treinamento.kotlinrecycler.R
import com.example.treinamento.kotlinrecycler.adapter.ProgrammingLanguageAdapter
import com.example.treinamento.kotlinrecycler.adapter.RepositoryAdapter
import com.example.treinamento.kotlinrecycler.api.GithubRepositoriesResult
import com.example.treinamento.kotlinrecycler.api.RepositoryRetriever
import com.example.treinamento.kotlinrecycler.model.ProgrammingLanguage
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val repositoryRetriever = RepositoryRetriever()

    private val callback = object :
        Callback<GithubRepositoriesResult> {
        override fun onFailure(
            call: Call<GithubRepositoriesResult>?,
            t: Throwable?
        ) {
            longToast("Fail loading repositories.")
            Log.e("MainActivity", "Problem calling Github API", t)
            Log.d(
                "MainActivity", "Fail on URL:${ call?.request()?.url()}")
        }

        override fun onResponse(
            call: Call<GithubRepositoriesResult>?,
            response: Response<GithubRepositoriesResult>
        ) {
            longToast("Load finished.")
            response.body()?.repositories?.let {
                recyclerView.adapter = RepositoryAdapter(
                    it,
                    this@MainActivity
                ){
                    toast("Clicked item: ${it.owner}")
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadDefaultRecyclerView()
    }

    private fun loadDefaultRecyclerView() {
        recyclerView.adapter =
                ProgrammingLanguageAdapter(
                    recyclerViewItems(),
                    this) {
                    longToast("Loading ${it.title} repositories...")
                    repositoryRetriever.getRepositories(
                        callback,
                        it.title
                    )
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


