package com.luc.data.di

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import com.luc.data.firestore.FirestoreData
import com.luc.data.firestore.FirestoreDataImpl
import com.luc.data.repository.MusicDataRepositoryImpl
import com.luc.domain.repository.MusicDataRepository
import org.koin.dsl.module


val firebaseModule = module {
    fun provideFirebaseFirestore(): Firestore {
        val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.getApplicationDefault())
            .build()

        FirebaseApp.initializeApp(options)

        return FirestoreClient.getFirestore()
    }

    single { provideFirebaseFirestore() }

    factory<FirestoreData> {
        FirestoreDataImpl(
            firestore = get(),
        )
    }

    factory<MusicDataRepository> { MusicDataRepositoryImpl(firestoreData = get()) }
}

val dataModule = listOf(firebaseModule)