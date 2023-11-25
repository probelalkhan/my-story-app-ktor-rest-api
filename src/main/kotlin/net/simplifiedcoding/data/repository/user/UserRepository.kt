package net.simplifiedcoding.data.repository.user

import net.simplifiedcoding.base.BaseResponse

interface UserRepository {
    suspend fun getUser(id: Int): BaseResponse<Any>
}