package kz.healthymom.presentation.base

import android.content.Intent
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import kz.healthymom.presentation.login.LoginActivity

/**
 * created by: Makhanov Madiyar
 * on: 12.04.2021
 */
abstract class BaseActivity(@LayoutRes contentLayoutId: Int) : AppCompatActivity(contentLayoutId) {
    fun logout() {
        val loginIntent = Intent(this, LoginActivity::class.java)
        startActivity(loginIntent)
        this.finish()
    }
}