package net.simplifiedcoding.data.models

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Story(
    val id: Int,
    val user: User? = null,
    var title: String,
    var content: String,
    var isDraft: Boolean = true,
    val createdAt: String
)