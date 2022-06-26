package net.simplifiedcoding.data.service.story

import net.simplifiedcoding.data.models.Story
import net.simplifiedcoding.routes.story.StoryParams

interface StoryService {
    suspend fun get(id: Int): Story?
    suspend fun add(storyParams: StoryParams): Story?
    suspend fun update(id: Int, storyParams: StoryParams): Boolean
    suspend fun delete(storyId: Int)
    suspend fun like(userId: Int, storyId: Int)
    suspend fun comment(userId: Int, comment: String)
}