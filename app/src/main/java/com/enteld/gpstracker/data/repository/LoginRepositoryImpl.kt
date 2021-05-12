package com.enteld.gpstracker.data.repository

import com.enteld.gpstracker.data.datasource.LoginDataSource
import com.enteld.gpstracker.domain.repository.LoginRepository

class LoginRepositoryImpl(
    private val dataSource: LoginDataSource
): LoginRepository {

    override fun isLoggedIn(): Boolean =
        dataSource.isLoggedIn()

    override fun login(userName: String) {
        dataSource.login(userName)
    }

    override fun getUserName(): String? =
        dataSource.getUserName()
}