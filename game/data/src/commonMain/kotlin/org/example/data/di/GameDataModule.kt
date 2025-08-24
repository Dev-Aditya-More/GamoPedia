package org.example.data.di

import org.example.data.repository.GameRepositoryImpl
import org.koin.dsl.module

fun getGameModule() = module{

    factory<GameRepositoryImpl>{
        GameRepositoryImpl(apiService = get())
    }
}