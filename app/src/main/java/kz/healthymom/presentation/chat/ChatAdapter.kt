package kz.healthymom.presentation.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_chat.view.*
import kz.healthymom.R

/**
 * created by: Makhanov Madiyar
 * on: 25.04.2021
 */
class ChatAdapter(
    private val items: List<Chat>,
    private val onChatPressed: (client: Chat) -> Unit
) : RecyclerView.Adapter<ChatListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_chat, parent, false)
        return ChatListViewHolder(view)
    }

    override fun getItemCount() = items.size
    override fun onBindViewHolder(holder: ChatListViewHolder, position: Int) {
        holder.itemView.cont.setOnClickListener {
            onChatPressed(items[position])
        }
        holder.itemView.name.text = items[position].name
        holder.itemView.lastMsg.text = items[position].lastMsg
        holder.itemView.time.text = items[position].time
    }
}

class ChatListViewHolder(view: View) : RecyclerView.ViewHolder(view)