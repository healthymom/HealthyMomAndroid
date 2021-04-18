package kz.healthymom.presentation.faq

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import kz.healthymom.R

/**
 * created by: Makhanov Madiyar
 * on: 18.04.2021
 */
class ExpandableFaqAdapter(
    private val context: Context,
    private val list: List<FAQGroup>
) : BaseExpandableListAdapter() {

    @SuppressLint("InflateParams")
    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val newView: View = convertView
            ?: (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                .inflate(R.layout.item_faq_group, null)

        val title: TextView = newView.findViewById(R.id.title)
        title.text = list[groupPosition].title
        return newView
    }

    @SuppressLint("InflateParams")
    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val newView: View = convertView
            ?: (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                .inflate(R.layout.item_faq, null)

        val title: TextView = newView.findViewById(R.id.child)
        title.text = list[groupPosition].title
        return newView
    }

    override fun getGroup(position: Int) = list[position]
    override fun getGroupCount() = list.size
    override fun getGroupId(groupPosition: Int) = groupPosition.toLong()
    override fun isChildSelectable(groupPosition: Int, childPosition: Int) = true
    override fun hasStableIds() = false
    override fun getChildId(groupPosition: Int, childPosition: Int) = childPosition.toLong()
    override fun getChildrenCount(groupPosition: Int) = list[groupPosition].items.size
    override fun getChild(groupPosition: Int, childPosition: Int) =
        list[groupPosition].items[childPosition]
}