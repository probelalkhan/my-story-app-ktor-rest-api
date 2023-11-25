package net.simplifiedcoding.routes.user

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.response.*
import io.ktor.routing.*
import net.simplifiedcoding.data.repository.user.UserRepository
import net.simplifiedcoding.security.UserIdPrincipalForUser

fun Application.userRoutes(repository: UserRepository) {
    routing {
        authenticate {
            route("/user") {
                get {
                    val principal = call.principal<UserIdPrincipalForUser>()
                    val result = repository.getUser(principal?.id!!)
                    call.respond(result.statusCode, result)
                }
            }
        }
    }
}