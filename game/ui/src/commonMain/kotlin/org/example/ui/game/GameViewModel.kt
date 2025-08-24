package org.example.ui.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import org.example.domain.model.Game
import org.example.domain.usecases.GetGamesUsecase

class GameViewModel(
    private val getGamesUsecase: GetGamesUsecase
) : ViewModel() {

    private val _uiState = MutableStateFlow(GameScreen.uiState())
    val uiState = _uiState.asStateFlow()

    init {
        getGames()
    }

    fun getGames() = getGamesUsecase.invoke()
        .onStart {
            _uiState.update {
                it.copy(isLoading = true)
            }
        }.onEach{ result ->

            result.onSuccess {
                _uiState.update {
                    it.copy(isLoading = false, data = it.data)
                }
            }.onFailure {
                _uiState.update {
                    it.copy(isLoading = false, error = it.error.toString())
                }
            }

        }.launchIn(viewModelScope)
}

object GameScreen{

    data class uiState(

        val isLoading : Boolean = false,
        val error : String = "",
        val data : List<Game>? = null

    )
}