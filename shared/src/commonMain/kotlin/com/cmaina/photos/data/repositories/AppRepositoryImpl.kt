package com.cmaina.photos.data.repositories

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.cmaina.photos.domain.models.settings.AppTheme
import com.cmaina.photos.domain.repositories.AppRepository
import com.cmaina.photos.presentation.utils.Language
import com.cmaina.photos.presentation.utils.PreferenceKeys
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Locale

class AppRepositoryImpl(
    private val preferences: DataStore<Preferences>
) : AppRepository {

    private val themePreference = intPreferencesKey(PreferenceKeys.AppTheme)
    private val languagePreference = stringPreferencesKey(PreferenceKeys.AppLanguage)

    override suspend fun fetchAppTheme(): Flow<AppTheme> {
        return preferences.data.map {
            when (it[themePreference]) {
                0 -> AppTheme.Light
                1 -> AppTheme.Dark
                else -> AppTheme.SystemDefault
            }
        }
    }

    override suspend fun saveAppTheme(theme: AppTheme) {
        preferences.updateData {
            it.toMutablePreferences().apply {
                set(
                    themePreference, when (theme) {
                        AppTheme.Light -> 0
                        AppTheme.Dark -> 1
                        AppTheme.SystemDefault -> 2
                    }
                )
            }
        }
    }

    override suspend fun fetchAppLanguage(): Flow<Language> {
        return preferences.data.map {
            when (it[languagePreference]) {
                "English" -> Language.English
                "Italian" -> Language.Italian
                "German" -> Language.German
                else -> Language.English
            }

        }
    }

    override suspend fun saveAppLanguage(language: Language) {
        preferences.updateData {
            it.toMutablePreferences().apply {
                set(
                    languagePreference, when (language) {
                        Language.English -> "English"
                        Language.Italian -> {
                            Locale.setDefault(Locale("it"))
                            "Italian"
                        }
                        Language.German -> "German"
                    }
                )
            }
        }
    }
}
