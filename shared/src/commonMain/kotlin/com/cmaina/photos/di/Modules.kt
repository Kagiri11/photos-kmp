package com.cmaina.photos.di

import org.koin.dsl.module

val networkModule = module {
/*    factory { photosRemoteSource }
    factory { usersRemoteSource }
    factory { authRemoteSource }*/
}

val dataModule = module {
//    single { provideDataStore(get()) }
}

val repositoryModule = module {
    /*single<PhotosRepository> { PhotosRepositoryImpl(photosRemoteSource = get()) }
    factory<UsersRepository> { UsersRepositoryImpl(usersRemoteSource = get()) }
    single<AuthRepository> { AuthRepositoryImpl(authRemoteSource = get(), preferences = get()) }
    factory<AppRepository> { AppRepositoryImpl(settings = AppSettings) }*/
}

val presentationModule = module {
    factory { HomeViewModel(photosRepository = get()) }
    factory { PhotoDetailsViewModel(photosRepository = get(), authRepository = get()) }
    factory { SettingsViewModel(appRepository = get()) }
    factory { UserViewModel(usersRepository = get(), photosRepository = get()) }
}