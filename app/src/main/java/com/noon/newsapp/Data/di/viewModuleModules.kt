package com.noon.newsapp.Data.di

import com.noon.newsapp.Data.UI.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { NewsViewModel(get()) }

}