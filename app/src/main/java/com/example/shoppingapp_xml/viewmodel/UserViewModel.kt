package com.example.shoppingapp_xml.viewmodel

import androidx.lifecycle.ViewModel
import com.example.shoppingapp_xml.networkmodel.User
import com.example.shoppingapp_xml.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    suspend fun login(user: User) = flow {
        val login = userRepository.login(user)
        emit(login)
    }.flowOn(Dispatchers.IO)

}