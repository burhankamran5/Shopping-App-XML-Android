package com.example.shoppingapp_xml.userstorage

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import javax.inject.Inject

class UserStorage @Inject constructor(private val context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("sharedPreferencesEStore", MODE_PRIVATE)






}