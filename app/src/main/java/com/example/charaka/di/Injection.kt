package com.example.charaka.di

import androidx.room.Room
import com.example.charaka.data.DataDataSource
import com.example.charaka.data.DataRepository
import com.example.charaka.data.local.LocalDataSource
import com.example.charaka.data.local.room.DataDatabase
import com.example.charaka.data.remote.RemoteDataSource
import com.example.charaka.ui.books.BooksViewModel
import com.example.charaka.ui.detail.DetailViewModel
import com.example.charaka.ui.detail.PostDetailViewModel
import com.example.charaka.ui.explore.ExploreViewModel
import com.example.charaka.ui.explore.SearchViewModel
import com.example.charaka.ui.home.HomeViewModel
import com.example.charaka.ui.profile.PostLikedViewModel
import com.example.charaka.ui.profile.PostSavedViewModel
import com.example.charaka.ui.profile.ProfileViewModel
import com.example.charaka.utils.AppExecutors
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val databaseModule = module {
        factory { get<DataDatabase>().dataDao() }
        single {
            Room.databaseBuilder(
                androidContext(),
                DataDatabase::class.java, "Charaka.db"
            ).fallbackToDestructiveMigration().build()
        }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource() }
    factory { AppExecutors() }
    single { DataRepository(get(), get(), get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { BooksViewModel(get()) }
    viewModel { ExploreViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    viewModel { ProfileViewModel(get()) }
    viewModel { PostDetailViewModel(get()) }
    viewModel { PostSavedViewModel(get()) }
    viewModel { PostLikedViewModel(get()) }
    viewModel { SearchViewModel() }
}