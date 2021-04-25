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
                lastMsg = "Как дела?",
                time = "14:32",
                image = ""
            )
        )
        l.add(
            Chat(
                name = "Толеби Мурзиятов",
                lastMsg = "Подкури брат",
                time = "13:30",
                image = ""
            )
        )
        l.add(
            Chat(
                name = "Данара Укиева",
                lastMsg = "Гоу",
                time = "10:21",
                image = ""
            )
        )
        l.add(
            Chat(
                name = "Мурзиятова Алма",
                lastMsg = "Спишь?",
                time = "02:05",
                image = ""
            )
        )

        list.adapter = ChatAdapter(l) {
            Log.d("AfdwsD", "AEFASD")
            val intent = Intent(requireContext(), DialogActivity::class.java)
            startActivity(intent)
        }
    }

    private fun observeLiveData() {

    }

    override fun onRefresh() {
        swipe.isRefreshing = false
    }
}