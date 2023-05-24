package com.example.shoppingapp_xml.repository

import com.example.shoppingapp_xml.network.ApiService
import com.example.shoppingapp_xml.networkmodel.User
import javax.inject.Inject


class UserRepository @Inject constructor(val apiService: ApiService){

suspend fun login(user: User) = apiService.login(user)

}