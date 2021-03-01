package com.franco.chat.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.franco.chat.R
import com.franco.domain.User

class ChatAdapter(
    private val context: Context
) : RecyclerView.Adapter<ChatAdapter.BaseViewHolder<*>>() {

    private var adapterDataList: List<Any> = emptyList()

    companion object {
        private const val USER_ONE = 1
        private const val USER_TWO = 2
    }
    abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: T)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            USER_ONE -> {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.right_item_user_one, parent, false)
                UserOneViewHolder(view)
            }
            USER_TWO -> {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.left_item_user_two, parent, false)
                UserTwoViewHolder(view)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val element = adapterDataList[position]
        when (holder) {
            is UserOneViewHolder -> holder.bind(element as User)
            is UserTwoViewHolder -> holder.bind(element as User)

            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount(): Int {
        return adapterDataList.size
    }

    override fun getItemViewType(position: Int): Int {
        val comparable = adapterDataList[position]
        return when (comparable) {
            is Int -> USER_ONE
            is Int -> USER_TWO
            else -> throw IllegalArgumentException("Invalid type of data " + position)
        }
    }

    inner class UserOneViewHolder(itemView: View) : BaseViewHolder<User>(itemView) {

        override fun bind(userOne: User) {
            //Do your view assignment here from the data model

        }
    }
    inner class UserTwoViewHolder(itemView: View) : BaseViewHolder<User>(itemView) {

        override fun bind(userTwo: User) {
            //Do your view assignment here from the data model
        }
    }
}

