package com.enteld.gpstracker.domain.usecase

import com.enteld.gpstracker.domain.repository.LoginRepository

class IsLoggedInUseCase(private val repository: LoginRepository) {

    operator fun invoke() =
        repository.isLoggedIn()
}