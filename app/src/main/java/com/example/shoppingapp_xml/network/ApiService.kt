package com.example.shoppingapp_xml.network

import com.example.shoppingapp_xml.networkmodel.UserToken
import com.example.shoppingapp_xml.result.Result
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {

    @POST("auth/login")
    suspend fun login(
        @Body user: HashMap<String, String>
    ):  UserToken


}