package kz.healthymom.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * created by: Makhanov Madiyar
 * on: 12.04.2021
 */
open class BaseViewModel : ViewModel() {
    val loading = MutableLiveData<Boolean>()
    val toast = MutableLiveData<Any>()
}