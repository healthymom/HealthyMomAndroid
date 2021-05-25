package kz.healthymom.presentation.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.idescout.sql.SqlScoutServer
import kotlinx.android.synthetic.main.activity_sign_in.*
import kz.healthymom.R
import kz.healthymom.presentation.base.BaseActivity
import kz.healthymom.presentation.main.MainActivity
import kz.healthymom.presentation.utils.toast
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * created by: Makhanov Madiyar
 * on: 12.04.2021
 */
class LoginActivity : AppCompatActivity() {
    private lateinit var signInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth
    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            try {
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account)
            } catch (e: ApiException) {
                e.printStackTrace()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        sign_in_button.setOnClickListener { signIn() }
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        signInClient = GoogleSignIn.getClient(this, gso)
        auth = Firebase.auth

        if (auth.currentUser != null) {
            // Not signed in, launch the Sign In activity
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            return
        }
    }

    private fun signIn() {
        val signInIntent = signInClient.signInIntent
        resultLauncher.launch(signInIntent)
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount?) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct?.id)
        val credential = GoogleAuthProvider.getCredential(acct?.idToken, null)
        auth.signInWithCredential(credential)
            .addOnSuccessListener(this) {
                // If sign in succeeds the auth state listener will be notified and logic to
                // handle the signed in user can be handled in the listener.
                Log.d(TAG, "signInWithCredential:success")
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
            }
            .addOnFailureListener(this) { e -> // If sign in fails, display a message to the user.
                Log.w(TAG, "signInWithCredential", e)
                Toast.makeText(
                    this@LoginActivity, "Authentication failed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    companion object {
        private const val TAG = "SignInActivity"
    }
}
