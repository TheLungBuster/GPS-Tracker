package com.enteld.gpstracker.domain.repository

interface LoginRepository {
    fun isLoggedIn(): Boolean
    fun login(userName: String)
    fun getUserName(): String?
}