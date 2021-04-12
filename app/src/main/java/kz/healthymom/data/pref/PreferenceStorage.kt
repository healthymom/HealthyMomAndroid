package kz.healthymom.data.pref

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import kz.healthymom.data.pref.utils.BooleanPreference
import kz.healthymom.data.pref.utils.StringPreference

/**
 * created by: Makhanov Madiyar
 * on: 12.04.2021
 */
class PreferenceStorage(context: Context) {
    private val prefs: Lazy<SharedPreferences> = lazy {
        context.applicationContext.getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
    }
    var isFingerprintAskedBefore by BooleanPreference(prefs, IS_FINGERPRINT_ASKED_BEFORE, false)
    var lang by StringPreference(prefs, LANG, null)

    companion object {
        private const val PREFS_NAME = "healthymom_prefs"
        private const val IS_FINGERPRINT_ASKED_BEFORE = "is_fingerprint_asked_before"
        private const val LANG = "lang"
    }
}