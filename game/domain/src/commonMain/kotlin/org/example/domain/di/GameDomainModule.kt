package org.example.domain.di

import org.example.domain.usecases.GetGamesUsecase
import org.koin.dsl.module

fun getDomainModule() = module{

    factory{ GetGamesUsecase(gameRepo = get()) }
}