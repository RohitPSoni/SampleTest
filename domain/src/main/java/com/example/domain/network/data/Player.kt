package com.example.domain.network.data

import com.google.gson.annotations.SerializedName

data class AllInfo(
    @SerializedName("data") val data: Data
)

data class Data(
    @SerializedName("players") val players: ArrayList<Players>
)

data class Players(
    @SerializedName("uid") val uid: String,
    @SerializedName("playerId") val playerId: String,
    @SerializedName("personName") val personName: PersonName,
    @SerializedName("images") val images: Images?,
    @SerializedName("country") val country: Country?,
    @SerializedName("age") val age: Int,
)

data class Country(
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String,
    @SerializedName("codeIoc") val codeIoc: String
)

data class Images(
    @SerializedName("action") val action: String,
    @SerializedName("headshot") val headshot: String,
    @SerializedName("photo") val photo: Photo?
)

data class Photo(
    @SerializedName("url") val url: String,
)

data class PersonName(
    @SerializedName("name") val name: String,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String?,
    @SerializedName("tvName") val tvName: String,
    @SerializedName("scoreboardName") val scoreboardName: String,
)