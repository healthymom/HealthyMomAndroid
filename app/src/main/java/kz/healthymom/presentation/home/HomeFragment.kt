package kz.healthymom.presentation.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.f_home.*
import kz.healthymom.PostActivity
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

        asdfsdf.setOnClickListener {
            startActivity(Intent(requireContext(), PostActivity::class.java))
        }
    }

    private fun initUI() {
        //swipe.setOnRefreshListener(this)
        Picasso.get()
            .load("https://rd.clinic23.ru/uploads/images/beremennost/14-nedele.jpg")
            .fit().centerCrop().into(imagg)

        Picasso.get()
            .load("https://yogaland.kz/wp-content/uploads/2016/11/yoga-dlya-beremennyh.jpg")
            .fit().centerCrop().into(imagg2)
    }

    private fun observeLiveData() {

    }

    override fun onRefresh() {
        //swipe.isRefreshing = false
    }
}