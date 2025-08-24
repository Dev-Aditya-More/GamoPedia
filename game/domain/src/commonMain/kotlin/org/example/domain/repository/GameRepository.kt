package org.example.domain.repository

import org.example.domain.model.Game

interface GameRepository {

    suspend fun getGames(): Result<List<Game>>

}