package org.example.coreNetwork.apiService

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.example.coreNetwork.model.game.GameResponse

class ApiService(
    val httpClient: HttpClient
){

    suspend fun getGames(): Result<GameResponse>{
        return try{

            val response = httpClient.get("api/games"){
                url{
                    parameter("key", "b146a1891c3d4d8bbf021bde84abc5ea")
                }
            }.body<GameResponse>()
            Result.success(response)

        }catch (e: Exception){

            Result.failure(e)
        }
    }
}