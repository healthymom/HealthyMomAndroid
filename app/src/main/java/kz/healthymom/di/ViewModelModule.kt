package kz.healthymom.di

import kz.healthymom.presentation.login.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * created by: Makhanov Madiyar
 * on: 12.04.2021
 */
val viewModelModule = module {
    viewModel { LoginViewModel() }
}