package com.franco.data

import com.franco.domain.User

class UserRepository (
    private val remoteDataSource:RemoteDataSourceSim
    ){
    fun getAllUsers():List<User>{
        return remoteDataSource.createAllUsers()
    }

}

