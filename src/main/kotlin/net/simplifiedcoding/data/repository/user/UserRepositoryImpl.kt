package net.simplifiedcoding.data.repository.user

import net.simplifiedcoding.base.BaseResponse
import net.simplifiedcoding.data.service.user.UserService

class UserRepositoryImpl(
    private val userService: UserService
) : UserRepository {

    override suspend fun getUser(id: Int): BaseResponse<Any> {
        return BaseResponse.SuccessResponse(data = userService.getUser(id))
    }
}