package net.simplifiedcoding.data.db.schemas

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

object LikeTable : Table("likes") {
    val id = integer("id").autoIncrement()
    val userId = integer("user_id").references(ref = UserTable.id, onDelete = ReferenceOption.CASCADE)
    val storyId = integer("story_id").references(ref = StoryTable.id, onDelete = ReferenceOption.CASCADE)
    val createdAt = datetime("created_at").clientDefault { LocalDateTime.now() }
    override val primaryKey = PrimaryKey(StoryTable.id)
}