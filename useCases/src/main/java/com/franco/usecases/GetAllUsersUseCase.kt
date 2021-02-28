package com.franco.usecases

import com.franco.data.RemoteDataSourceSim
import com.franco.data.UserRepository

import com.franco.domain.User

class GetAllUsersUseCase (
    private val userRepository: UserRepository
        ):InterfaceGetAllUsersUseCase {

    override fun createAllUsers():List<User> =userRepository.createAllUsers()
}