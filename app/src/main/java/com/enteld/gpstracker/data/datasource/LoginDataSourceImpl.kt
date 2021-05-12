package com.enteld.gpstracker.data.datasource

import android.content.Context
import androidx.core.content.edit

class LoginDataSourceImpl(context: Context): LoginDataSource {

    private companion object {

        const val USER_PREFERENCES = "USER_PREFERENCES"
        const val USER_NAME_VALUE = "USER_NAME_VALUE"
        const val LOGIN_VALUE = "LOGIN_VALUE"
        const val USER_NAME_DEFAULT_VALUE = ""
        const val LOGIN_DEFAULT_VALUE = false
    }

    private val sharedPreferences = context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE)

    override fun isLoggedIn(): Boolean =
        sharedPreferences.getBoolean(LOGIN_VALUE, LOGIN_DEFAULT_VALUE)

    override fun login(value: String) {
        sharedPreferences.edit(commit = true) {
            putBoolean(LOGIN_VALUE, true)
            putString(USER_NAME_VALUE, value)
        }
    }

    override fun getUserName(): String? =
        sharedPreferences.getString(USER_NAME_VALUE, USER_NAME_DEFAULT_VALUE)
}