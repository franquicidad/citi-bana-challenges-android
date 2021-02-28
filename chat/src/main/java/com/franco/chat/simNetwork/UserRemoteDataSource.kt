package com.franco.chat.simNetwork


import com.franco.chat.util.fromDomainToNetwork
import com.franco.chat.util.fromNetworkToDomainMapper
import com.franco.data.RemoteDataSourceSim
import com.franco.domain.User

class UserRemoteDataSource(
    private val apiService: ApiService
):  RemoteDataSourceSim{

    override fun createAllUsers(): List<User> {
        return  apiService.createAllUsers().map {
            it.fromNetworkToDomainMapper()
        }
    }

}