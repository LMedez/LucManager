package com.luc.domain.usecases

import com.luc.common.NetworkStatus
import com.luc.common.model.SongMetadata
import com.luc.domain.repository.MusicDataRepository

interface AddDataUseCase {
    suspend fun addSongMetadata(songMetadata: SongMetadata):  NetworkStatus<String>
}

class AddDataUseCaseImpl(private val musicDataRepository: MusicDataRepository) : AddDataUseCase {
    override suspend fun addSongMetadata(songMetadata: SongMetadata) : NetworkStatus<String> {

        return musicDataRepository.addSongMetadata(songMetadata)
    }

}