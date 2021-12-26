package com.luc.data.repository

import com.luc.common.NetworkStatus
import com.luc.common.model.SongMetadata
import com.luc.data.firestore.FirestoreData
import com.luc.domain.repository.MusicDataRepository

class MusicDataRepositoryImpl(private val firestoreData: FirestoreData) : MusicDataRepository {

    override suspend fun addSongMetadata(songMetadata: SongMetadata): NetworkStatus<String> {
        return firestoreData.addSongMetadata(songMetadata)
    }

}