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
            list.add(FAQGroup("Ощущение болезненного жжения в нижней части груди, особенно в положении лежа.", listOf(FAQItem(" Прекратите курение, употребление алкогольных напитков, сладкой и острой пищи."))))
            list.add(FAQGroup("Неприятное ощущение, во время беременности чаще всего сводит икроножные мышцы и стопу.", listOf(FAQItem("Вытяните ноги и подержите их в таком положении в течение минуты."))))
            list.add(FAQGroup("Ощущение усталости и слабости из -за железодефицитной анемии.", listOf(FAQItem("Старайтесь питаться продуктами с повышенным содержанием железа (мясо, вишня, абрикосы, миндаль, зеленые овощи)."))))
            list.add(FAQGroup("Происходят из – за прибавления веса и гормональных изменений во время беременности происходит растяжение кожи на животе, бедрах и груди. Чаще всего у женщин, имевших целлюлит до беременности.", listOf(FAQItem("Плавание и легкая гимнастика улучшает эластичность кожи."))))
            list.add(FAQGroup("При беременности часты варикозное расширение вен и отеки. Если вы страдали этим до беременности, сейчас состояние может ухудшиться.", listOf(FAQItem("Массируйте ноги холодной водой."))))
            list.add(FAQGroup("Как правило начинается после 20-ой недели. За время беременности Вы должны прибавить не более 10-12 кг. Прибавка веса за неделю не более 200- 250 гр.", listOf(FAQItem("Питайтесь сбалансировано. Ешьте больше овощей и фруктов."))))
            list.add(FAQGroup("Повышенное давление и вегетососудистая дистония до беременности могут стать серьезной проблемой на поздних сроках.", listOf(FAQItem("Обязательно проконсультируйтесь с врачом."))))
            list.add(FAQGroup("После 6-го месяца из сосков могут появляться выделения.", listOf(FAQItem("Соблюдайте гигиену (мойте и насухо вытирайте соски)"))))
            faqList.postValue(list)
        }
    }
}