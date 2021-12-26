package com.luc.domain.di

import com.luc.domain.usecases.AddDataUseCase
import com.luc.domain.usecases.AddDataUseCaseImpl
import org.koin.dsl.module


val useCaseModule = module {
    factory <AddDataUseCase>{ AddDataUseCaseImpl(musicDataRepository = get()) }
}

val domainModule = listOf(useCaseModule)
