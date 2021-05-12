package com.enteld.gpstracker.domain.di

import com.enteld.gpstracker.domain.usecase.GetUserNameUseCase
import com.enteld.gpstracker.domain.usecase.IsLoggedInUseCase
import com.enteld.gpstracker.domain.usecase.LoginUseCase
import com.enteld.gpstracker.domain.usecase.SendLocationUseCase
import org.koin.dsl.module

val DomainModule = module {
    factory { SendLocationUseCase() }
    factory { GetUserNameUseCase(get()) }
    factory { IsLoggedInUseCase(get()) }
    factory { LoginUseCase(get()) }
}