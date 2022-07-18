package net.simplifiedcoding.data.models

data class Comment(
    val id: Int,
    val userId: Int,
    val storyId: Int,
    val comment: String,
    val createdAt: String
)