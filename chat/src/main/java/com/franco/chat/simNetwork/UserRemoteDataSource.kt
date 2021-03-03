package com.franco.chat.simNetwork


import com.franco.chat.util.fromNetworkToDomainMapper
import com.franco.data.sources.RemoteDataSourceSim
import com.franco.domain.User
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    private val apiService: ApiService
): RemoteDataSourceSim {

    override fun createAllUsers(): List<User> {
        return  apiService.createAllUsers().map {
            it.fromNetworkToDomainMapper()
        }
    }

}