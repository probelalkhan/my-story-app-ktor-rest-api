package net.simplifiedcoding.data.service.story

import net.simplifiedcoding.data.db.DatabaseFactory
import net.simplifiedcoding.data.db.extensions.toStory
import net.simplifiedcoding.data.db.schemas.StoryTable
import net.simplifiedcoding.data.models.Story
import net.simplifiedcoding.routes.story.StoryParams
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.statements.InsertStatement
import org.jetbrains.exposed.sql.update

class StoryServiceImpl : StoryService {

    override suspend fun get(id: Int): Story? {
        val storyRow = DatabaseFactory.dbQuery { StoryTable.select { StoryTable.id eq id }.first() }
        return storyRow.toStory()
    }

    override suspend fun add(storyParams: StoryParams): Story? {
        var statement: InsertStatement<Number>? = null
        DatabaseFactory.dbQuery {
            statement = StoryTable.insert {
                it[userId] = storyParams.userId
                it[title] = storyParams.title
                it[content] = storyParams.content
                it[isDraft] = storyParams.isDraft
            }
        }
        return statement?.resultedValues?.get(0).toStory()
    }

    override suspend fun update(id: Int, storyParams: StoryParams): Boolean {
        var result = -1
        DatabaseFactory.dbQuery {
            result = StoryTable.update({ StoryTable.id eq id }) {
                it[userId] = storyParams.userId
                it[title] = storyParams.title
                it[content] = storyParams.content
                it[isDraft] = storyParams.isDraft
            }
        }
        return result == 1
    }

    override suspend fun delete(storyId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun like(userId: Int, storyId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun comment(userId: Int, comment: String) {
        TODO("Not yet implemented")
    }
}