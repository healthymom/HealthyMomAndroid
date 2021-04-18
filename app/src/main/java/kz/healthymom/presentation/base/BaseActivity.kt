package kz.healthymom.presentation.base

import android.content.Intent
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import kz.healthymom.presentation.login.LoginActivity

/**
 * created by: Makhanov Madiyar
 * on: 12.04.2021
 */
abstract class BaseActivity(@LayoutRes contentLayoutId: Int) : AppCompatActivity(contentLayoutId) {
    override fun onStart() {
        super.onStart()
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }

    fun logout() {
        val loginIntent = Intent(this, LoginActivity::class.java)
        startActivity(loginIntent)
        this.finish()
    }
}