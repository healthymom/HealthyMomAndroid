package kz.healthymom.presentation.login

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kz.healthymom.presentation.base.BaseViewModel

/**
 * created by: Makhanov Madiyar
 * on: 12.04.2021
 */
class LoginViewModel() : BaseViewModel() {

    fun signIn(login: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }
}