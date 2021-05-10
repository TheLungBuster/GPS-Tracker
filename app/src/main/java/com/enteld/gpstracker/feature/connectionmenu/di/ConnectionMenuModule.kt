package com.enteld.gpstracker.feature.connectionmenu.di

import com.enteld.gpstracker.feature.connectionmenu.presentation.ConnectionMenuViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ConnectionMenuModule = module {
    viewModel { ConnectionMenuViewModel() }
}