package net.simplifiedcoding.data.service.story

import net.simplifiedcoding.data.models.Comment
import net.simplifiedcoding.data.models.Story
import net.simplifiedcoding.data.models.common.PaginatedResult
import net.simplifiedcoding.routes.story.StoryParams

interface StoryService {
    suspend fun get(id: Int): Story?
    suspend fun getMyStories(userId: Int, page: Int, limit: Int, isDraft: Boolean): PaginatedResult<Story>
    suspend fun getAllStories(page: Int, limit: Int): PaginatedResult<Story>
    suspend fun getLikedStories(userId: Int): List<Story>
    suspend fun add(storyParams: StoryParams): Story?
    suspend fun update(id: Int, storyParams: StoryParams): Boolean
    suspend fun delete(storyId: Int): Boolean
    suspend fun like(userId: Int, storyId: Int): Boolean
    suspend fun comment(userId: Int, storyId: Int, comment: String): Boolean
    suspend fun getComments(storyId: Int): List<Comment>
}