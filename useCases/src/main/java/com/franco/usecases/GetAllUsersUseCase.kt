package com.franco.usecases

import com.franco.data.IUserRepository
import com.franco.domain.User
import javax.inject.Inject

class GetAllUsersUseCase  @Inject constructor (
    private val userRepository: IUserRepository
        ) : IGetAllUsersUseCase {

     override fun createAllUsers():List<User> =userRepository.createAllUsers()
}