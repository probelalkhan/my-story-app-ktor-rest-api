package net.simplifiedcoding.data.service.user

import net.simplifiedcoding.data.models.User

interface UserService {
    suspend fun getUser(id: Int): User
}