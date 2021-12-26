package com.luc.data.firestore

import com.google.cloud.firestore.Firestore
import com.luc.common.NetworkStatus
import com.luc.common.model.SongMetadata
import com.luc.data.firestore.Constants.SONG_COLLECTION_NAME
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FirestoreDataImpl(private val firestore: Firestore) : FirestoreData {
    override suspend fun addSongMetadata(songMetadata: SongMetadata): NetworkStatus<String> {
        return try {
            withContext(Dispatchers.IO) {
                val data = firestore.collection(SONG_COLLECTION_NAME).add(songMetadata)
                NetworkStatus.Success(data.get().id)
            }

        } catch (e: Exception) {
            NetworkStatus.Error(e,"Error adding song")
        }
    }
}

object Constants {
    const val SONG_COLLECTION_NAME = "songs"
}