package com.cmaina.photos.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath

fun createDataStore(producePath: () -> String = { DataStoreFileName}): DataStore<Preferences> =
    PreferenceDataStoreFactory.createWithPath(produceFile = {
        producePath().toPath()
    })

internal const val DataStoreFileName = "photos.preferences_pb"