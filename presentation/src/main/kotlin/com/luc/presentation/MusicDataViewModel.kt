package com.luc.presentation

import com.luc.common.NetworkStatus
import com.luc.common.model.SongMetadata
import com.luc.domain.usecases.AddDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext

class MusicDataViewModel(private val addDataUseCase: AddDataUseCase) {

    private val _isFetching = MutableStateFlow(false)
    val isFetching: StateFlow<Boolean>
        get() = _isFetching

    private val _successfullyAdded = MutableStateFlow("")
    val  successfullyAdded: StateFlow<String>
        get() = _successfullyAdded


    suspend fun addSongMetadata(songMetadata: SongMetadata) {
        _isFetching.value = true
        when (val result = addDataUseCase.addSongMetadata(songMetadata)) {
            is NetworkStatus.Success -> {
                _isFetching.value = false
                _successfullyAdded.value = "Song metadata added successfully. Id ${result.data}"
            }
            else -> {}
        }
    }

}