package com.cmaina.photos.di

import com.cmaina.photos.data.network.client.createClient
import com.cmaina.photos.data.network.sources.AuthRemoteSource
import com.cmaina.photos.data.network.sources.PhotosRemoteSource
import com.cmaina.photos.data.network.sources.UsersRemoteSource
import com.cmaina.photos.data.repositories.AppRepositoryImpl
import com.cmaina.photos.data.repositories.AuthRepositoryImpl
import com.cmaina.photos.data.repositories.PhotosRepositoryImpl
import com.cmaina.photos.data.repositories.UsersRepositoryImpl
import com.cmaina.photos.domain.repositories.AppRepository
import com.cmaina.photos.domain.repositories.AuthRepository
import com.cmaina.photos.domain.repositories.PhotosRepository
import com.cmaina.photos.domain.repositories.UsersRepository
import com.cmaina.photos.presentation.screens.home.HomeViewModel
import com.cmaina.photos.presentation.screens.photodetails.PhotoDetailsViewModel
import com.cmaina.photos.presentation.screens.settings.SettingsViewModel
import com.cmaina.photos.presentation.screens.user.UserViewModel
import io.ktor.client.HttpClient
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

val networkModule = module {
    single<HttpClient> { createClient() }
    factory { PhotosRemoteSource(client = get()) }
    factory { UsersRemoteSource(client = get()) }
    factory { AuthRemoteSource(client = get()) }
}

val repositoryModule = module {
    single<PhotosRepository> { PhotosRepositoryImpl(photosRemoteSource = get()) }
    factory<UsersRepository> { UsersRepositoryImpl(usersRemoteSource = get()) }
    single<AuthRepository> { AuthRepositoryImpl(authRemoteSource = get(), preferences = get()) }
    factory<AppRepository> { AppRepositoryImpl() }
}

val presentationModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::PhotoDetailsViewModel)
    viewModelOf(::SettingsViewModel)
    viewModelOf(::UserViewModel)
}

expect fun platformModule(): Module