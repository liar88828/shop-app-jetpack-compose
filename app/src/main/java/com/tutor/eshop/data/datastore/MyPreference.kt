package com.tutor.eshop.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

val Context.myPreference: DataStore<Preferences> by preferencesDataStore("settings")

@Singleton
class MyPreferenceDataStore @Inject constructor(
	@ApplicationContext context: Context
) {
	private val myPreferenceDataStore = context.myPreference

	private object PreferencesKeys {
		val APP_ENTRY_KEY = booleanPreferencesKey("app_entry")
	}

	val readAppEntry = myPreferenceDataStore.data
		.catch { exception ->
			if (exception is Exception) {
				emit(emptyPreferences())
			} else {
				throw exception
			}
		}
		.map { preference ->
			preference[PreferencesKeys.APP_ENTRY_KEY] ?: true
		}

	suspend fun saveAppEntry() {
		myPreferenceDataStore.edit { preference ->
			preference[PreferencesKeys.APP_ENTRY_KEY] = false
		}
	}

}