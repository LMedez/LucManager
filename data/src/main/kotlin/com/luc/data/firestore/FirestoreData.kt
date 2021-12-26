package com.luc.data.firestore

import com.luc.common.NetworkStatus
import com.luc.common.model.SongMetadata

interface FirestoreData {
    suspend fun addSongMetadata(songMetadata: SongMetadata) : NetworkStatus<String>
}