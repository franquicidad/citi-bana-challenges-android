package com.franco.data

import com.franco.DANIELA
import com.franco.RODRIGO
import com.franco.domain.User
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val remoteDataSourceSim: RemoteDataSourceSim
    ):RemoteDataSourceSim {
    override fun createAllUsers(): List<User> {
        return remoteDataSourceSim.createAllUsers()
    }
}

