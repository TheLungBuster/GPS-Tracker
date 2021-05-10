package com.enteld.gpstracker.domain.di

import com.enteld.gpstracker.domain.usecase.SendLocationUseCase
import org.koin.dsl.module

val DomainModule = module {
    factory { SendLocationUseCase() }
}