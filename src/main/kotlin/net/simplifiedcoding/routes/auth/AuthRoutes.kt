package net.simplifiedcoding.routes.auth

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.utils.io.*
import net.simplifiedcoding.data.repository.auth.AuthRepository

fun Application.authRoutes(repository: AuthRepository) {
    routing {
        route("/auth") {

            post("/register") {
                try {
                    val params = call.receive<CreateUserParams>()
                    val result = repository.registerUser(params)
                    call.respond(result.statusCode, result)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            post("/login") {
                val params = call.receive<UserLoginParams>()
                val result = repository.loginUser(params)
                call.respond(result.statusCode, result)
            }
        }
    }
}