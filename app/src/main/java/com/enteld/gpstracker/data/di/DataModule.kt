package com.enteld.gpstracker.data.di

import com.enteld.gpstracker.data.datasource.LoginDataSource
import com.enteld.gpstracker.data.datasource.LoginDataSourceImpl
import com.enteld.gpstracker.data.repository.LoginRepositoryImpl
import com.enteld.gpstracker.domain.repository.LoginRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val DataModule = module {

    single<LoginDataSource> { LoginDataSourceImpl(androidContext()) }
    factory<LoginRepository> { LoginRepositoryImpl(get()) }
}