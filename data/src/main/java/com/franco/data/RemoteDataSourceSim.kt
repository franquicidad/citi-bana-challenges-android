package com.franco.data

import com.franco.domain.User

interface RemoteDataSourceSim {
    fun createAllUsers():List<User>
}