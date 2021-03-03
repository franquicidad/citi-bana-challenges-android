package com.franco.data

import com.franco.data.sources.RemoteDataSourceSim
import com.franco.domain.User
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val remoteDataSourceSim: RemoteDataSourceSim
    ) : IUserRepository {
     override fun createAllUsers(): List<User> {
        return remoteDataSourceSim.createAllUsers()
    }
}

