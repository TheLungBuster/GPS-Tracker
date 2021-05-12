package com.enteld.gpstracker.data.datasource

interface LoginDataSource {
    fun isLoggedIn(): Boolean
    fun login(value: String)
    fun getUserName(): String?
}