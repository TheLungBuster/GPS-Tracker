package com.enteld.gpstracker.feature.login.di

import com.enteld.gpstracker.feature.login.presentation.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val LoginModule = module {
    viewModel {
        LoginViewModel(
            loginUseCase = get(),
            isLoggedInUseCase = get()
        )
    }
}