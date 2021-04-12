package kz.healthymom.di

import kz.healthymom.data.room.LocalDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * created by: Makhanov Madiyar
 * on: 12.04.2021
 */
val databaseModule = module {
    single { LocalDatabase(androidContext()).getProfileDao() }
}