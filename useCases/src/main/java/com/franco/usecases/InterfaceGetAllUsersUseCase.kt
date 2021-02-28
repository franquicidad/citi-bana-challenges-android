package com.franco.usecases

import com.franco.domain.User

interface InterfaceGetAllUsersUseCase {
    fun createAllUsers():List<User>
}