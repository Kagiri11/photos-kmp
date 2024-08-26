package com.cmaina.photos.data.repositories

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.cmaina.photos.domain.models.settings.AppTheme
import com.cmaina.photos.domain.models.settings.AppThemes
import com.cmaina.photos.domain.repositories.AppRepository
import com.cmaina.photos.presentation.utils.Language
import com.cmaina.photos.presentation.utils.LanguageList
import com.cmaina.photos.presentation.utils.PreferenceKeys
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class AppRepositoryImpl(
    private val preferences: DataStore<Preferences>
) : AppRepository {

    private val themePreference = stringPreferencesKey(PreferenceKeys.AppTheme)
    private val languagePreference = stringPreferencesKey(PreferenceKeys.AppLanguage)

    override suspend fun fetchAppTheme(): Flow<AppTheme> {
        return preferences.data.map { pref ->
            AppThemes.find { it.entity.name == pref[themePreference] }
                ?: return@map AppThemes.first()
        }
    }

    override suspend fun saveAppTheme(theme: AppTheme) {
        preferences.updateData {
            it.toMutablePreferences().apply {
                set(themePreference, theme.entity.name)
            }
        }
    }

    override suspend fun fetchAppLanguage(): Flow<Language> {
        return preferences.data.map { pref ->
            LanguageList.find { it.name == pref[languagePreference] }
                ?: return@map LanguageList.first()
        }
    }

    override suspend fun saveAppLanguage(language: Language) {
        preferences.updateData {
            it.toMutablePreferences().apply {
                set(languagePreference, language.name)
            }
        }
    }
}
