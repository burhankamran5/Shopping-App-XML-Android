package com.example.shoppingapp_xml.repository

import com.example.shoppingapp_xml.networkmodel.User
import com.example.shoppingapp_xml.services.UserService
import javax.inject.Inject


class UserRepository @Inject constructor(private val userService: UserService) {
    suspend fun login(user: User) = userService.login(user)

}