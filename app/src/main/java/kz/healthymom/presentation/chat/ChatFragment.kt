package kz.healthymom.presentation.chat

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.f_chat.*
import kz.healthymom.R
import kz.healthymom.presentation.base.BaseFragment
import kz.healthymom.presentation.chat.dialog.DialogActivity
import kz.healthymom.presentation.test.TestActivity

/**
 * created by: Makhanov Madiyar
 * on: 18.04.2021
 */
class ChatFragment : BaseFragment(R.layout.f_chat), SwipeRefreshLayout.OnRefreshListener {
    companion object {
        fun newInstance() = ChatFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        observeLiveData()
    }

    private fun initUI() {
        swipe.setOnRefreshListener(this)


        val l = arrayListOf<Chat>()
        l.add(
            Chat(
                name = "Маханов Мадияр",
                lastMsg = "Привет",
                time = "Только что",
                image = ""
            )
        )

        l.add(
            Chat(
                name = "Шабденова Эльмира Дуйсенхановна",
                lastMsg = "Как самочувствие?",
                time = "10 минут назад",
                image = "https://idoctor.kz//images/doctors/1001/1332/optimized/3DKefYAMFtBXbBImuBDk1fdE5mc31eG2ixfRKlUK_300x300-q-85.jpeg"
            )
        )

        l.add(
            Chat(
                name = "Павлова Ольга Николаевна",
                lastMsg = "Завтра на узи)))",
                time = "Вчера",
                image = "https://idoctor.kz//images/doctors/2001/2368/optimized/25VY0WH5dXNUnOVs4MdVxxFXe1o6pEr78e47Cyss_300x300-q-85.jpeg"
            )
        )

        l.add(
            Chat(
                name = "Ким Татьяна Валерьевна",
                lastMsg = "Как дела?",
                time = "25.05.21",
                image = "https://idoctor.kz//images/doctors/31001/30500/optimized/inqBHYwb5w2mhNOfGQ45U7VdkTzuOb6pwA0xYRtx_300x300-q-85.jpeg"
            )
        )

        list.adapter = ChatAdapter(l) {
            Log.d("AfdwsD", "AEFASD")
            val intent = Intent(requireContext(), TestActivity::class.java)
            startActivity(intent)
        }
    }

    private fun observeLiveData() {

    }

    override fun onRefresh() {
        swipe.isRefreshing = false
    }
}