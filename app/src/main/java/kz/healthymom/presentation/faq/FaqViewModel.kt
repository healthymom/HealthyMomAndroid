package kz.healthymom.presentation.faq

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kz.healthymom.presentation.base.BaseViewModel

/**
 * created by: Makhanov Madiyar
 * on: 18.04.2021
 */
class FaqViewModel : BaseViewModel() {
    val faqList = MutableLiveData<List<FAQGroup>>()

    fun loadFaq() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = arrayListOf<FAQGroup>()
            list.add(FAQGroup("ewd3rfew", listOf(FAQItem("dewdewfe"))))
            list.add(FAQGroup("ewd3rfew", listOf(FAQItem("dewdewfe"))))
            list.add(FAQGroup("ewd3rfew", listOf(FAQItem("dewdewfe"))))
            list.add(FAQGroup("ewd3rfew", listOf(FAQItem("dewdewfe"))))
            list.add(FAQGroup("ewd3rfew", listOf(FAQItem("dewdewfe"))))
            list.add(FAQGroup("ewd3rfew", listOf(FAQItem("dewdewfe"))))
            list.add(FAQGroup("ewd3rfew", listOf(FAQItem("dewdewfe"))))
            list.add(FAQGroup("ewd3rfew", listOf(FAQItem("dewdewfe"))))
            list.add(FAQGroup("ewd3rfew", listOf(FAQItem("dewdewfe"))))
            list.add(FAQGroup("ewd3rfew", listOf(FAQItem("dewdewfe"))))
            list.add(FAQGroup("ewd3rfew", listOf(FAQItem("dewdewfe"))))
            list.add(FAQGroup("ewd3rfew", listOf(FAQItem("dewdewfe"))))
            list.add(FAQGroup("ewd3rfew", listOf(FAQItem("dewdewfe"))))
            list.add(FAQGroup("ewd3rfew", listOf(FAQItem("dewdewfe"))))
            list.add(FAQGroup("ewd3rfew", listOf(FAQItem("dewdewfe"))))
            list.add(FAQGroup("ewd3rfew", listOf(FAQItem("dewdewfe"))))
            list.add(FAQGroup("ewd3rfew", listOf(FAQItem("dewdewfe"))))
            list.add(FAQGroup("ewd3rfew", listOf(FAQItem("dewdewfe"))))
            list.add(FAQGroup("ewd3rfew", listOf(FAQItem("dewdewfe"))))
            list.add(FAQGroup("ewd3rfew", listOf(FAQItem("dewdewfe"))))
            list.add(FAQGroup("ewd3rfew", listOf(FAQItem("dewdewfe"))))
            list.add(FAQGroup("ewd3rfew", listOf(FAQItem("dewdewfe"))))
            list.add(FAQGroup("ewd3rfew", listOf(FAQItem("dewdewfe"))))
            faqList.postValue(list)
        }
    }
}