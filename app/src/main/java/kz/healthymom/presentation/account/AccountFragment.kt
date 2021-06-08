package kz.healthymom.presentation.account

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.f_account.*
import kz.healthymom.PostActivity
import kz.healthymom.ProfileActivity
import kz.healthymom.R
import kz.healthymom.presentation.base.BaseFragment
import kz.healthymom.presentation.login.LoginActivity

/**
 * created by: Makhanov Madiyar
 * on: 18.04.2021
 */
class AccountFragment : BaseFragment(R.layout.f_account) {
    companion object {
        fun newInstance() = AccountFragment()
    }

    private lateinit var signInClient: GoogleSignInClient
    // Firebase instance variables
    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        observeLiveData()

        auth = Firebase.auth
        if (auth.currentUser == null) {
            // Not signed in, launch the Sign In activity
            startActivity(Intent(requireContext(), LoginActivity::class.java))
            requireActivity().finish()
            return
        }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        signInClient = GoogleSignIn.getClient(requireContext(), gso)

        profile_image.setOnClickListener {
            startActivity(Intent(requireContext(), ProfileActivity::class.java))
        }

        settings.setOnClickListener {
            signOut()
        }
    }

    private fun signOut() {
        auth.signOut()
        signInClient.signOut()
        startActivity(Intent(requireContext(), LoginActivity::class.java))
        requireActivity().finish()
    }

    private fun initUI() {

    }

    private fun observeLiveData() {

    }
}