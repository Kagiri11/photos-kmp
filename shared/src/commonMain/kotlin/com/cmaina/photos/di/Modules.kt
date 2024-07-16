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
import org.koin.dsl.module

val networkModule = module {
    factory { photosRemoteSource }
    factory { usersRemoteSource }
    factory { authRemoteSource }
}

val dataModule = module {
    single { provideDataStore(get()) }
}

val repositoryModule = module {
    single<PhotosRepository> { PhotosRepositoryImpl(photosRemoteSource = get()) }
    factory<UsersRepository> { UsersRepositoryImpl(usersRemoteSource = get()) }
    single<AuthRepository> { AuthRepositoryImpl(authRemoteSource = get(), preferences = get()) }
    factory<AppRepository> { AppRepositoryImpl() }
}

val presentationModule = module {
   /* factory { HomeViewModel(photosRepository = get()) }
    factory { PhotoDetailsViewModel(photosRepository = get(), authRepository = get()) }
    factory { SettingsViewModel(appRepository = get()) }
    factory { UserViewModel(usersRepository = get(), photosRepository = get()) }*/
}

expect fun platformModule() : Module