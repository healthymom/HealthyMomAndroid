package kz.healthymom.presentation.base

import android.content.Intent
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import kz.healthymom.presentation.login.LoginActivity

/**
 * created by: Makhanov Madiyar
 * on: 12.04.2021
 */
abstract class BaseFragment(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId) {
    fun logout() {
        val loginIntent = Intent(context, LoginActivity::class.java)
        startActivity(loginIntent)
        activity?.finish()
    }
}