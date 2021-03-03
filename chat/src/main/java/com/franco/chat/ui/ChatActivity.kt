package com.franco.chat.ui

import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.franco.chat.R
import com.franco.chat.databinding.UserChatBinding
import com.franco.domain.User
import com.franco.usecases.GetAllUsersUseCase
import dagger.android.support.DaggerAppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ChatActivity (

) : AppCompatActivity(),MainPresenter.View{

    @Inject
    lateinit var getAllUsersUseCase: GetAllUsersUseCase
   // @Inject
    private val presenter=MainPresenter(getAllUsersUseCase)
    //private val presenter by lazy { MainPresenter(getAllUsersUseCase) }
    private lateinit var binding :UserChatBinding
    private lateinit var adapter: ChatAdapter
    private lateinit var list: List<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UserChatBinding.inflate(layoutInflater)
            setContentView(binding.root)


        with(binding) {
               binding.presenter!!.onCreate(this@ChatActivity)
               list = mutableListOf()
               list = presenter!!.getChatUser(getAllUsersUseCase.createAllUsers())!!

               recyclerViewChat.adapter = ChatAdapter(this@ChatActivity, list)

           }

    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun getUsersChat(getAllUsersUseCase: GetAllUsersUseCase): List<User> {
        return getAllUsersUseCase.createAllUsers()
    }


}