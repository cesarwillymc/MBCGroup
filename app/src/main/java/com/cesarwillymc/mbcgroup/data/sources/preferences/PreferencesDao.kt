package com.cesarwillymc.mbcgroup.data.sources.preferences
import com.cesarwillymc.mbcgroup.util.state.Result

interface PreferencesDao {

    val getToken: Result<String>
    fun saveToken(value: String): Result<Unit>
    val getTokenType: Result<String>
    fun saveTokenType(value: String): Result<Unit>

    val isLogged: Result<Boolean>
    fun cleanPreferences(): Result<Unit>
}
