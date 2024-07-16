package com.cmaina.photos

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.cmaina.photos.data.local.createDataStore
import com.cmaina.photos.data.local.dataStoreFileName

fun createAndroidDataStore(context: Context): DataStore<Preferences> = createDataStore(
    producePath = { context.filesDir.resolve(dataStoreFileName).absolutePath }
)