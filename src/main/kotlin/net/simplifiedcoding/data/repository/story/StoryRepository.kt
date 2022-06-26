package net.simplifiedcoding.data.repository.story

import net.simplifiedcoding.base.BaseResponse
import net.simplifiedcoding.routes.story.StoryParams

interface StoryRepository {
    suspend fun add(storyParams: StoryParams): BaseResponse<Any>
    suspend fun update(id: Int, storyParams: StoryParams): BaseResponse<Any>
    suspend fun delete(storyId: Int): BaseResponse<Any>
    suspend fun like(userId: Int, storyId: Int)
    suspend fun comment(userId: Int, comment: String)
}