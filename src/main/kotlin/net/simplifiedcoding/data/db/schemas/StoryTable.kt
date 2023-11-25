package net.simplifiedcoding.data.db.schemas

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

object StoryTable : Table("stories") {
    val id = integer("id").autoIncrement()
    val userId = integer("user_id").references(ref = UserTable.id, onDelete = ReferenceOption.CASCADE)
    val title = varchar("title", 256)
    val content = text("content")
    val isDraft = bool("is_draft").clientDefault { true }
    val createdAt = datetime("created_at").clientDefault { LocalDateTime.now() }
    override val primaryKey = PrimaryKey(id)
}