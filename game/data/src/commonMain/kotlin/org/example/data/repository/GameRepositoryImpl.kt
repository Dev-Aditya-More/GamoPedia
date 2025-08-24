package org.example.data.repository

import org.example.coreNetwork.apiService.ApiService
import org.example.data.mapper.toDomainListOfGames
import org.example.domain.model.Game
import org.example.domain.repository.GameRepository

class GameRepositoryImpl(
    private val apiService: ApiService
) : GameRepository{

    override suspend fun getGames(): Result<List<Game>> {
        val response = apiService.getGames()

        return if(response.isSuccess){

            Result.success(response.getOrThrow().results.toDomainListOfGames())
        }
        else{
            Result.failure(response.exceptionOrNull()!!)
        }
    }
}