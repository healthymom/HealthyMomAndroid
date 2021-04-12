package kz.healthymom.presentation.utils

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kz.healthymom.data.model.response.BaseResponse
import kz.healthymom.data.model.response.NetResult
import retrofit2.Response

/**
 * created by: Makhanov Madiyar
 * on: 12.04.2021
 */
fun AppCompatActivity.toast(message: String, lengthShort: Boolean = false) {
    var length = Toast.LENGTH_LONG
    if (lengthShort)
        length = Toast.LENGTH_SHORT

    val toast: Toast = Toast.makeText(this, message, length)
    toast.show()
}

fun AppCompatActivity.toast(@StringRes message: Int, lengthShort: Boolean = false) {
    var length = Toast.LENGTH_LONG
    if (lengthShort)
        length = Toast.LENGTH_SHORT

    val toast: Toast = Toast.makeText(this, message, length)
    toast.show()
}

fun AppCompatActivity.toast(message: Any, lengthShort: Boolean = false) {
    var length = Toast.LENGTH_LONG
    if (lengthShort)
        length = Toast.LENGTH_SHORT

    var toast: Toast? = null
    if (message is Int)
        toast = Toast.makeText(this, message, length)
    else if (message is String)
        toast = Toast.makeText(this, message, length)

    toast?.show()
}

fun Fragment.toast(message: String, lengthShort: Boolean = false) {
    var length = Toast.LENGTH_LONG
    if (lengthShort)
        length = Toast.LENGTH_SHORT

    val toast: Toast = Toast.makeText(requireContext(), message, length)
    toast.show()
}

fun Fragment.toast(@StringRes message: Int, lengthShort: Boolean = false) {
    var length = Toast.LENGTH_LONG
    if (lengthShort)
        length = Toast.LENGTH_SHORT

    val toast: Toast = Toast.makeText(requireContext(), message, length)
    toast.show()
}

fun Fragment.toast(message: Any, lengthShort: Boolean = false) {
    try {
        var length = Toast.LENGTH_LONG
        if (lengthShort)
            length = Toast.LENGTH_SHORT

        var toast: Toast? = null
        if (message is Int)
            toast = Toast.makeText(requireContext(), message, length)
        else if (message is String)
            toast = Toast.makeText(requireContext(), message, length)

        toast?.show()
    } catch (e: Exception) {

    }
}

fun AppCompatActivity.hideKeyboard() {
    val imm: InputMethodManager =
        getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    var view: View? = currentFocus
    if (view == null) {
        view = View(this)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Fragment.hideKeyboard() {
    val imm: InputMethodManager =
        requireContext().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    var view: View? = requireActivity().currentFocus
    if (view == null) {
        view = View(requireContext())
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun <T> Response<BaseResponse<T>>.getResult(): NetResult<T> {
    return when (code()) {
        200, 201 -> (body() as BaseResponse<T>).getResult()
        404 -> NetResult.Error("404")
        413 -> NetResult.Error("413")
        500 -> NetResult.Error("500")
        else -> NetResult.Error("!ERROR!")
    }
}