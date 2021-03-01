package com.franco.chat.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.franco.chat.R
import com.franco.chat.databinding.UserChatBinding
import com.franco.domain.User
import com.franco.usecases.GetAllUsersUseCase
import com.franco.usecases.InterfaceGetAllUsersUseCase

class ChatActivity(
     getAllUsersUseCase: InterfaceGetAllUsersUseCase
) : AppCompatActivity() ,MainPresenter.View{

    private val presenter by lazy { MainPresenter(getAllUsersUseCase) }
    private lateinit var binding :UserChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UserChatBinding.inflate(layoutInflater).apply {
            setContentView(root)
            presenter.onCreate(this@ChatActivity)
            recyclerViewChat.adapter = adapter
        }

    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun getUsersChat(userChatList: List<User>) {
        adapter.userChatList =userChatList
    }
}