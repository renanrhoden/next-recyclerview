package com.example.treinamento.kotlinrecycler.api

import com.google.gson.annotations.SerializedName

class GithubRepositoriesResult(
    @SerializedName("items")
    val repositories: List<Repository>
)

data class Repository(
    val id: Long?,
    val name: String?,
    val full_name: String?,
    val owner: Owner?,
    val html_url: String?,
    val description: String?
)

data class Owner(
    val id: Long?,
    val login: String?,
    val avatar_url: String?
)