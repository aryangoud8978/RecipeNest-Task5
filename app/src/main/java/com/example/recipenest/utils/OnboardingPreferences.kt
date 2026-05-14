package com.example.recipenest.utils

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(
    name = "onboarding_prefs"
)

class OnboardingPreferences(
    private val context: Context
) {

    companion object {

        private val HAS_SEEN_ONBOARDING =
            booleanPreferencesKey(
                "has_seen_onboarding"
            )
    }

    val hasSeenOnboarding: Flow<Boolean> =

        context.dataStore.data.map { preferences ->

            preferences[HAS_SEEN_ONBOARDING]
                ?: false
        }

    suspend fun saveOnboardingState() {

        context.dataStore.edit { preferences ->

            preferences[HAS_SEEN_ONBOARDING] = true
        }
    }
}