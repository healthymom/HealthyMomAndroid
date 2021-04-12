package kz.healthymom.di

import kz.healthymom.data.pref.PreferenceStorage
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


/**
 * created by: Makhanov Madiyar
 * on: 12.04.2021
 */
val dataModule = module {
    single { PreferenceStorage(androidContext()) }
}