package com.franco.chat.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.franco.chat.databinding.UserChatBinding
import com.franco.chat.simNetwork.ApiService
import com.franco.data.sources.RemoteDataSourceSim
import com.franco.data.UserRepository
import com.franco.domain.User
import com.franco.usecases.GetAllUsersUseCase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ChatActivity (

) : AppCompatActivity(),MainPresenter.View{

    @Inject
    lateinit var getAllUsersUseCase: GetAllUsersUseCase
/*  @Inject*/
  lateinit var  presenter:MainPresenter
//    //private val presenter by lazy { MainPresenter(getAllUsersUseCase) }
    private lateinit var binding :UserChatBinding
//    private lateinit var adapter: ChatAdapter
    private lateinit var list: List<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UserChatBinding.inflate(layoutInflater)
            setContentView(binding.root)
        /*val repository=UserRepository(remoteDataSourceSim)*/
/*
        val getAllUsersUseCase= GetAllUsersUseCase(repository)
*/
/*
        presenter= MainPresenter(getAllUsersUseCase)
*/
        with(binding) {
            binding.presenter= MainPresenter(getAllUsersUseCase)
               binding.presenter!!.onCreate(this@ChatActivity)
               list = mutableListOf()
               list = presenter!!.getChatUser()!!

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