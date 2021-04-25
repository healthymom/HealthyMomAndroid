package kz.healthymom.presentation.account

import android.os.Bundle
import android.view.View
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.f_info.*
import kz.healthymom.R
import kz.healthymom.presentation.base.BaseFragment

/**
 * created by: Makhanov Madiyar
 * on: 18.04.2021
 */
class InfoFragment : BaseFragment(R.layout.f_info), SwipeRefreshLayout.OnRefreshListener {
    companion object {
        fun newInstance() = InfoFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        observeLiveData()
    }

    private fun initUI() {
        swipe.setOnRefreshListener(this)
    }

    private fun observeLiveData() {

    }

    override fun onRefresh() {
        swipe.isRefreshing = false
    }
}