package com.orange.archhelloworld.featureplaceholder.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orange.archhelloworld.featureplaceholder.domain.usecase.IPlaceHolderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlaceHolderViewModel @Inject constructor(
    private val placeHolderUseCase: IPlaceHolderUseCase
) : ViewModel() {

    private val _placeHolderUiState =
        MutableStateFlow<PlaceHolderUiState>(PlaceHolderUiState.Loading)
    val placeHolderUiState: StateFlow<PlaceHolderUiState> = _placeHolderUiState.asStateFlow()

    fun onScreenDisplayed() {
        viewModelScope.launch {
            ensureActive()
            placeHolderUseCase.getHelloWorld()
                .map { message ->
                    _placeHolderUiState.value = PlaceHolderUiState.Success(message)
                }.collect()
        }
    }
}

sealed interface PlaceHolderUiState {

    data class Success(val message: String) : PlaceHolderUiState

    object Loading : PlaceHolderUiState

}