package kz.healthymom.presentation.chat

import android.os.Bundle
import android.view.View
import kz.healthymom.R
import kz.healthymom.presentation.base.BaseFragment

/**
 * created by: Makhanov Madiyar
 * on: 18.04.2021
 */
class ChatFragment : BaseFragment(R.layout.f_chat) {
    companion object {
        fun newInstance() = ChatFragment()
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