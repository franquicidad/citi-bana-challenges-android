package com.franco.chat.ui

import com.franco.domain.User
import com.franco.usecases.InterfaceGetAllUsersUseCase
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val getAllUsersUseCase: InterfaceGetAllUsersUseCase
) {
    interface View{
        fun getUsersChat(userChatList:List<User>)
    }
    private var view:View? =null
    fun onCreate(view:View) {
        this.view=view

        view.getUsersChat(getAllUsersUseCase.createAllUsers())
    }

    fun onDestroy() {
        this.view=null
    }


}