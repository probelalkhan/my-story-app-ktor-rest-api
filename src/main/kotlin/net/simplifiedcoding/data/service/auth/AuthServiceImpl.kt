package net.simplifiedcoding.data.service.auth

import net.simplifiedcoding.data.db.DatabaseFactory.dbQuery
import net.simplifiedcoding.data.db.extensions.toUser
import net.simplifiedcoding.data.db.schemas.UserTable
import net.simplifiedcoding.data.models.User
import net.simplifiedcoding.routes.auth.CreateUserParams
import net.simplifiedcoding.security.hash
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.statements.InsertStatement

class AuthServiceImpl : AuthService {
    override suspend fun registerUser(params: CreateUserParams): User? {
        var statement: InsertStatement<Number>? = null
        dbQuery {
            statement = UserTable.insert {
                it[email] = params.email
                it[password] = hash(params.password)
                it[fullName] = params.fullName
                it[avatar] = params.avatar
            }
        }
        return statement?.resultedValues?.get(0).toUser()
    }

    override suspend fun loginUser(email: String, password: String): User? {
        val hashedPassword = hash(password)
        val userRow = dbQuery { UserTable.select { UserTable.email eq email and (UserTable.password eq hashedPassword) }.firstOrNull() }
        return userRow.toUser()
    }

    override suspend fun findUserByEmail(email: String): User? {
        val user = dbQuery {
            UserTable.select { UserTable.email.eq(email) }
                .map { it.toUser() }.singleOrNull()
        }
        return user
    }
}