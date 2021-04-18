package kz.healthymom.presentation.account

import android.os.Bundle
import android.view.View
import kz.healthymom.R
import kz.healthymom.presentation.base.BaseFragment

/**
 * created by: Makhanov Madiyar
 * on: 18.04.2021
 */
class AccountFragment : BaseFragment(R.layout.f_account) {
    companion object {
        fun newInstance() = AccountFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        observeLiveData()
    }

    private fun initUI() {

    }

    private fun observeLiveData() {

    }
}