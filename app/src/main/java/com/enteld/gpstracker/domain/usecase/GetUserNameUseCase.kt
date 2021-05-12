package com.enteld.gpstracker.domain.usecase

import com.enteld.gpstracker.domain.repository.LoginRepository

class GetUserNameUseCase(private val repository: LoginRepository) {

    operator fun invoke() =
        repository.getUserName()
}