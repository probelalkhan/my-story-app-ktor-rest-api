package net.simplifiedcoding.data.db.extensions

import net.simplifiedcoding.data.db.schemas.StoryTable
import net.simplifiedcoding.data.db.schemas.UserTable
import net.simplifiedcoding.data.models.Story
import net.simplifiedcoding.data.models.User
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow?.toUser(): User? {
    return if (this == null) null
    else User(
        id = this[UserTable.id],
        fullName = this[UserTable.fullName],
        avatar = this[UserTable.avatar],
        email = this[UserTable.email],
        createdAt = this[UserTable.createdAt].toString(),
    )
}

fun ResultRow?.toStory(): Story? {
    return if (this == null) null
    else Story(
        id = this[StoryTable.id],
        userId = this[StoryTable.userId],
        title = this[StoryTable.title],
        content = this[StoryTable.content],
        isDraft = this[StoryTable.isDraft],
        createdAt = this[StoryTable.createdAt].toString()
    )
}