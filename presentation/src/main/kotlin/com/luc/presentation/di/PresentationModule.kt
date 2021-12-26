package com.luc.presentation.di

import com.luc.presentation.MusicDataViewModel
import org.koin.dsl.module

val presentationModule = module {
    single { MusicDataViewModel(get()) }
}
