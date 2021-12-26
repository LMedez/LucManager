package com.luc.domain.repository

import com.luc.common.NetworkStatus
import com.luc.common.model.SongMetadata
interface MusicDataRepository {
    suspend fun addSongMetadata(songMetadata: SongMetadata): NetworkStatus<String>
}