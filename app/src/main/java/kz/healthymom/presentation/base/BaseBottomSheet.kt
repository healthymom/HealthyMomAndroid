package kz.healthymom.presentation.base

import android.app.Activity
import android.content.DialogInterface
import android.view.inputmethod.InputMethodManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * created by: Makhanov Madiyar
 * on: 12.04.2021
 */
abstract class BaseBottomSheet : BottomSheetDialogFragment() {

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        val inputMethodManager =
            activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}