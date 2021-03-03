package com.franco.data.sources

import com.franco.domain.User

interface RemoteDataSourceSim {
    fun createAllUsers():List<User>
}