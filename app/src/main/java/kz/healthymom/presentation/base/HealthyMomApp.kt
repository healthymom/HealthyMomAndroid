package kz.healthymom.presentation.base

import android.app.Application
import android.content.Context
import kz.healthymom.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * created by: Makhanov Madiyar
 * on: 12.04.2021
 */
class HealthyMomApp : Application() {

    companion object {
        lateinit var CONTEXT: Context
    }

    override fun onCreate() {
        super.onCreate()
        CONTEXT = this

        startKoin {
            androidContext(this@HealthyMomApp)
            modules(
                listOf(
                    databaseModule,
                    dataModule,
                    networkModule,
                    repoModule,
                    viewModelModule
                )
            )
        }
    }
}