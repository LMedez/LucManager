package com.luc.common.model

import com.google.cloud.firestore.annotation.DocumentId

data class SongMetadata(
    @DocumentId val id: String = "",
    val title: String = "",
    val albumName: String = "",
    val imageUrl: String = "",
    val source: String = "",
    val artist: String = "",
    val trackNumber: Long = 0,
    val songDuration: String = ""
)
