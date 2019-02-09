package com.example.treinamento.kotlinrecycler.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface GitHubService {
    @GET("search/repositories")
    fun searchRepositiories(
        @Query("q") query: String,
        @Query("sort") sort: String = "stars",
        @Query("order") order: String = "desc"
    ) : Call<GithubRepositoriesResult>
}