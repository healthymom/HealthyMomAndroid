package kz.healthymom.presentation.home

import android.os.Bundle
import android.view.View
import kz.healthymom.R
import kz.healthymom.presentation.base.BaseFragment

/**
 * created by: Makhanov Madiyar
 * on: 18.04.2021
 */
class HomeFragment : BaseFragment(R.layout.f_home) {
    companion object {
        fun newInstance() = HomeFragment()
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