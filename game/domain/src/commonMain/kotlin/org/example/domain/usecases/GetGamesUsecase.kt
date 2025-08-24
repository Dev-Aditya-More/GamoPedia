package org.example.domain.usecases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.example.domain.model.Game
import org.example.domain.repository.GameRepository

class GetGamesUsecase(
    private val gameRepo : GameRepository
) {
    operator fun invoke() = flow<Result<List<Game>>>{
        emit(gameRepo.getGames())
    }.catch{
        emit(Result.failure(it))
    }.flowOn(
        Dispatchers.IO
    )
}