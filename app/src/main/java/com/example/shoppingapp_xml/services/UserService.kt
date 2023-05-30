package com.example.shoppingapp_xml.services

import com.example.shoppingapp_xml.network.ApiService
import com.example.shoppingapp_xml.networkmodel.User
import com.example.shoppingapp_xml.networkmodel.UserToken
import com.example.shoppingapp_xml.result.Result
import javax.inject.Inject

class UserService @Inject constructor(private val apiService: ApiService) {

    suspend fun login(user: User): Result<UserToken> {
        val userMap = HashMap<String, String>()
        userMap["username"] = user.username
        userMap["password"] = user.password
        return try {
            val result = apiService.login(userMap)
            Result.Success(result)
        } catch (error: Exception) {
            Result.Error(error)
        }

    }

}