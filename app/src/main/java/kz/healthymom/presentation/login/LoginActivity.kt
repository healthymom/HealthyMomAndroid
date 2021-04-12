package kz.healthymom.presentation.login

import android.os.Bundle
import androidx.lifecycle.Observer
import com.idescout.sql.SqlScoutServer
import kz.healthymom.R
import kz.healthymom.presentation.base.BaseActivity
import kz.healthymom.presentation.utils.toast
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * created by: Makhanov Madiyar
 * on: 12.04.2021
 */
class LoginActivity : BaseActivity(R.layout.activity_main) {
    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        SqlScoutServer.create(this, packageName);
        super.onCreate(savedInstanceState)


        observeLiveData()
        initUI()
    }

    private fun initUI() {
    }

    private fun observeLiveData() {
        loginViewModel.toast.observe(this, Observer {
            toast(it)
        })
    }
}