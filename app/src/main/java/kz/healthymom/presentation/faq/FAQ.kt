package kz.healthymom.presentation.faq

/**
 * created by: Makhanov Madiyar
 * on: 18.04.2021
 */
data class FAQGroup(
    val title: String,
    val items: List<FAQItem>
)

data class FAQItem(
    val title: String
)