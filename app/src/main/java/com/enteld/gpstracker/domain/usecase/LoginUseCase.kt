package com.enteld.gpstracker.domain.usecase

import com.enteld.gpstracker.domain.repository.LoginRepository

class LoginUseCase(private val repository: LoginRepository) {

    operator fun invoke(userName: String) =
        repository.login(userName)
}