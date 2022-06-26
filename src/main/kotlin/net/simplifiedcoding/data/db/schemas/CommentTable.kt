package net.simplifiedcoding.data.db.schemas

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object CommentTable : Table("comments") {
    val id = integer("id").autoIncrement()
    val userId = integer("user_id").references(ref = UserTable.id, onDelete = ReferenceOption.CASCADE)
    val storyId = integer("story_id").references(ref = StoryTable.id, onDelete = ReferenceOption.CASCADE)
    val comment = text("comment")
    override val primaryKey = PrimaryKey(StoryTable.id)
}