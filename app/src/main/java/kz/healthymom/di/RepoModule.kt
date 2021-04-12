package kz.healthymom.di

import kz.healthymom.data.repo.UserRepo
import kz.healthymom.data.repo.impl.UserRepoImpl
import org.koin.dsl.module

/**
 * created by: Makhanov Madiyar
 * on: 12.04.2021
 */
val repoModule = module {
    single { UserRepoImpl() as UserRepo }
}