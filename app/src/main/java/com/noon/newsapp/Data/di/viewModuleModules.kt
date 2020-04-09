package com.noon.newsapp.Data.di

import com.noon.newsapp.Data.UI.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule : Module = module {

    viewModel { NewsViewModel(get()) }

}