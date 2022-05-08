package net.simplifiedcoding.data.service.auth

import net.simplifiedcoding.data.models.User
import net.simplifiedcoding.routes.auth.CreateUserParams

interface AuthService {
    suspend fun registerUser(params: CreateUserParams): User?
    suspend fun loginUser(email: String, password: String): User?
    suspend fun findUserByEmail(email: String): User?
}