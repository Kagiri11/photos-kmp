package com.cmaina.photos.android

import android.app.Application
import com.cmaina.photos.di.initKoin
import org.koin.android.ext.koin.androidContext

class PhotosApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@PhotosApplication)
        }
    }
}