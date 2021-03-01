package com.franco.chat.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.franco.chat.R
import com.franco.chat.databinding.LeftItemUserTwoBinding
import com.franco.chat.databinding.RightItemUserOneBinding
import com.franco.domain.User

class ChatAdapter(
    private val context: Context ,
    private val userList: List<User>
) : RecyclerView.Adapter<ChatAdapter.BaseViewHolder<*>>() {



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
        val element = userList[position]
        when (holder) {
            is UserOneViewHolder -> holder.bind(element as User)
            is UserTwoViewHolder -> holder.bind(element as User)

            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun getItemViewType(position: Int): Int {
        if(userList.get(position).id.equals(USER_ONE)){
            return 1
        }else{
            return 2
        }
//        val comparable = adapterDataList[position]
//        return when (comparable) {
//            is Int -> USER_ONE
//            is Int -> USER_TWO
//            else -> throw IllegalArgumentException("Invalid type of data " + position)
//        }
    }

    inner class UserOneViewHolder(itemView: View) : BaseViewHolder<User>(itemView) {
            val binding= RightItemUserOneBinding.bind(itemView)
        override fun bind(userOne: User) {
            with(binding){
                senderMessageRight.text = userOne.userName
                messageRight.text=userOne.message
                timestampRight.text=userOne.timeStamp
            }

        }
    }
    inner class UserTwoViewHolder(itemView: View) : BaseViewHolder<User>(itemView) {
            val bindingLeft= LeftItemUserTwoBinding.bind(itemView)
        override fun bind(userTwo: User) {
            with(bindingLeft){
                senderMessageLeft.text= userTwo.userName
                messageLeft.text = userTwo.message
                timestampLeft.text = userTwo.timeStamp
            }
        }
    }
}

