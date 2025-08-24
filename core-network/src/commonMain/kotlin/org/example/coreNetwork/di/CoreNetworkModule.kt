package org.example.coreNetwork.di

import org.example.coreNetwork.apiService.ApiService
import org.example.coreNetwork.client.ktorClient
import org.koin.dsl.module

fun getCoreNetworkModule() = module {

    single { ApiService(httpClient = ktorClient.getInstance()) }
}