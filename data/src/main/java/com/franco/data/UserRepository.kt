package com.franco.data

import com.franco.domain.User

class UserRepository (
    private val remoteDataSourceSim: RemoteDataSourceSim
    ) {
     fun createAllUsers(): List<User> {
        return remoteDataSourceSim.createAllUsers()
    }
}

