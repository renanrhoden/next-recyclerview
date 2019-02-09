package com.example.treinamento.kotlinrecycler.api

import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryRetriever {

    private val service: GitHubService

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(GitHubService::class.java)
    }

    fun getRepositories(
        calback: Callback<GithubRepositoriesResult>,
        query: String
    ) {
        service.searchRepositiories("language:$query")
            .enqueue(calback)
    }
}