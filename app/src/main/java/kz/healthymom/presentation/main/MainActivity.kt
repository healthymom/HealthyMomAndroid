package kz.healthymom.presentation.main

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kz.healthymom.R
import kz.healthymom.presentation.account.AccountFragment
import kz.healthymom.presentation.account.ProfileFragment
import kz.healthymom.presentation.base.BaseActivity
import kz.healthymom.presentation.calendar.CalendarFragment
import kz.healthymom.presentation.chat.ChatFragment
import kz.healthymom.presentation.faq.FaqFragment
import kz.healthymom.presentation.home.HomeFragment
import kz.healthymom.presentation.utils.MainTab
import kz.healthymom.presentation.utils.MainTab.*

/**
 * created by: Makhanov Madiyar
 * on: 12.04.2021
 */
class MainActivity : BaseActivity(R.layout.activity_main) {
    private val homeFragment = HomeFragment.newInstance()
    private val calendarFragment = CalendarFragment.newInstance()
    private val chatFragment = ChatFragment.newInstance()
    private val faqFragment = FaqFragment.newInstance()
    private val accountFragment = ProfileFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initUI()
        observeLiveData()

        loadFragment(HOME_TAB)
    }

    private fun initUI() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction
            .add(R.id.frame, homeFragment)
            .add(R.id.frame, calendarFragment)
            .add(R.id.frame, chatFragment)
            .add(R.id.frame, faqFragment)
            .add(R.id.frame, accountFragment)
            .commit()

        bottom_menu.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> loadFragment(HOME_TAB)
                R.id.calendar -> loadFragment(CALENDAR_TAB)
                R.id.chat -> loadFragment(CHAT_TAB)
                R.id.faq -> loadFragment(FAQ_TAB)
                R.id.account -> loadFragment(ACCOUNT_TAB)
            }
            true
        }
    }

    private fun loadFragment(tab: MainTab) {
        val transaction = supportFragmentManager.beginTransaction()
        when (tab) {
            HOME_TAB -> {
                transaction.show(homeFragment)
                transaction.hide(calendarFragment)
                transaction.hide(chatFragment)
                transaction.hide(faqFragment)
                transaction.hide(accountFragment)
            }
            CALENDAR_TAB -> {
                transaction.show(calendarFragment)
                transaction.hide(homeFragment)
                transaction.hide(chatFragment)
                transaction.hide(faqFragment)
                transaction.hide(accountFragment)
            }
            CHAT_TAB -> {
                transaction.show(chatFragment)
                transaction.hide(homeFragment)
                transaction.hide(calendarFragment)
                transaction.hide(faqFragment)
                transaction.hide(accountFragment)
            }
            FAQ_TAB -> {
                transaction.show(faqFragment)
                transaction.hide(homeFragment)
                transaction.hide(calendarFragment)
                transaction.hide(chatFragment)
                transaction.hide(accountFragment)
            }
            ACCOUNT_TAB -> {
                transaction.show(accountFragment)
                transaction.hide(homeFragment)
                transaction.hide(calendarFragment)
                transaction.hide(chatFragment)
                transaction.hide(faqFragment)
            }
        }
        transaction.commit()
    }

    private fun observeLiveData() {

    }
}