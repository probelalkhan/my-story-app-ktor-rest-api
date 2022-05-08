package net.simplifiedcoding.data.service.user

import net.simplifiedcoding.data.db.DatabaseFactory.dbQuery
import net.simplifiedcoding.data.db.extensions.toUser
import net.simplifiedcoding.data.db.schemas.UserTable
import net.simplifiedcoding.data.models.User
import org.jetbrains.exposed.sql.select

class UserServiceImpl : UserService {
    override suspend fun getUser(id: Int): User {
        val userRow = dbQuery { UserTable.select { UserTable.id eq id }.first() }
        return userRow.toUser()!!
    }
}