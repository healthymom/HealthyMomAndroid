package kz.healthymom.presentation.faq

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.f_faq.*
import kz.healthymom.R
import kz.healthymom.presentation.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * created by: Makhanov Madiyar
 * on: 18.04.2021
 */
class FaqFragment : BaseFragment(R.layout.f_faq), SwipeRefreshLayout.OnRefreshListener {
    companion object {
        fun newInstance() = FaqFragment()
    }

    private val viewModel: FaqViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        observeLiveData()

        viewModel.loadFaq()
    }

    private fun initUI() {
        swipe.setOnRefreshListener(this)
    }

    private fun observeLiveData() {
        viewModel.faqList.observe(viewLifecycleOwner, Observer {
            val adapter = ExpandableFaqAdapter(requireContext(), it)
            list.setAdapter(adapter)
        })
    }

    override fun onRefresh() {
        swipe.isRefreshing = false
    }
}