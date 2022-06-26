package net.simplifiedcoding.data.models

data class Story(
    val id: Int,
    val userId: Int,
    var title: String,
    var content: String,
    var isDraft: Boolean = true,
    val createdAt: String
)