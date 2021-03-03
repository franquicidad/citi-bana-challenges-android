package com.franco.chat.ui

import com.franco.domain.User
import com.franco.usecases.GetAllUsersUseCase
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val getAllUsersUseCase: GetAllUsersUseCase
) {
    interface View{
        fun getUsersChat(getAllUsersUseCase: GetAllUsersUseCase): List<User>
    }
    private var view:View? =null
    fun onCreate(view:View) {
        this.view=view
        getChatUser(getAllUsersUseCase.createAllUsers())
    }

    fun onDestroy() {
        this.view=null
    }

    fun getChatUser(userList:List<User>): List<User>? {
        return userList

    }


}