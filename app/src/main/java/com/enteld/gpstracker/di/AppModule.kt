package com.enteld.gpstracker.di

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val AppModule = module {
    factory { CoroutineScope(Dispatchers.IO) }
}