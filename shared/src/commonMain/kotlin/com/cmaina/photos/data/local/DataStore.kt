package com.cmaina.photos.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath

fun createDataStore(producePath: () -> String = { dataStoreFileName}): DataStore<Preferences> =
    PreferenceDataStoreFactory.createWithPath(produceFile = {
        producePath().toPath()
    })

internal const val dataStoreFileName = "photos.preferences_pb"