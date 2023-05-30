package com.example.shoppingapp_xml.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.shoppingapp_xml.networkmodel.User
import com.example.shoppingapp_xml.repository.UserRepository
import com.example.shoppingapp_xml.result.Result
import com.example.shoppingapp_xml.userstorage.UserStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository,
    val userStorage: UserStorage
) : ViewModel() {

    suspend fun login(user: User) = flow {
        val login = userRepository.login(user)
        when (login) {
            is Result.Success<*> -> {
                //setting token coming from API in sharedPref
                userStorage.setActiveToken(login.data?.token.toString())
            }
            else -> {

            }
        }

        emit(login)
    }.flowOn(Dispatchers.IO)

}