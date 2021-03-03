package com.franco.usecases

import com.franco.domain.User

interface IGetAllUsersUseCase {
    fun createAllUsers(): List<User>
}