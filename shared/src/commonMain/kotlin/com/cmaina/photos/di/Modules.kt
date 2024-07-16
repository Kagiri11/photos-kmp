package com.cmaina.photos.di

import com.cmaina.fotos.shared.data.network.sources.authRemoteSource
import com.cmaina.fotos.shared.data.network.sources.photosRemoteSource
import com.cmaina.fotos.shared.data.network.sources.usersRemoteSource
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
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

val networkModule = module {
    factory { photosRemoteSource }
    factory { usersRemoteSource }
    factory { authRemoteSource }
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