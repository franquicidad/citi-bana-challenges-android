package com.franco.usecases

import com.franco.data.UserRepository

import com.franco.domain.User

class GetAllUsersUseCase (
    private val userRepository: UserRepository
        ) {

     fun createAllUsers():List<User> =userRepository.createAllUsers()
}