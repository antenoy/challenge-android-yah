package com.challenge.mob.repository

import com.challenge.mob.repository.maincategory.JsonRessources
import retrofit2.Call
import retrofit2.http.GET

interface ChallengeServices {
    @GET("categories.json")
    fun getCategory(): Call<JsonRessources>
}