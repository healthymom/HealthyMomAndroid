package kz.healthymom.presentation.home

import android.os.Bundle
import android.view.View
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.f_home.*
import kz.healthymom.R
import kz.healthymom.presentation.base.BaseFragment

/**
 * created by: Makhanov Madiyar
 * on: 18.04.2021
 */
class HomeFragment : BaseFragment(R.layout.f_home), SwipeRefreshLayout.OnRefreshListener {
    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        observeLiveData()
    }

    private fun initUI() {
        swipe.setOnRefreshListener(this)
        Picasso.get()
            .load("https://leleka.com.ua/content/news/004000-005000/photo_beremennosti_08_4747.jpg")
            .fit().centerCrop().into(imagg)
    }

    private fun observeLiveData() {

    }

    override fun onRefresh() {
        swipe.isRefreshing = false
    }
}