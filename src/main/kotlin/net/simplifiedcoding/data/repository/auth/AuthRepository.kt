package net.simplifiedcoding.data.repository.auth

import net.simplifiedcoding.base.BaseResponse
import net.simplifiedcoding.routes.auth.CreateUserParams
import net.simplifiedcoding.routes.auth.UserLoginParams

interface AuthRepository {
    suspend fun registerUser(params: CreateUserParams): BaseResponse<Any>
    suspend fun loginUser(params: UserLoginParams): BaseResponse<Any>
}