package com.franco.data

import com.franco.domain.User

interface IUserRepository {
    fun createAllUsers(): List<User>
}