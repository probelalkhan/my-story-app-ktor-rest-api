package net.simplifiedcoding.security

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import io.ktor.http.*
import io.ktor.response.*
import net.simplifiedcoding.base.BaseResponse
import net.simplifiedcoding.config.INVALID_AUTHENTICATION_TOKEN

fun Application.configureSecurity() {
    JwtConfig.initialize("my-story-app")
    install(Authentication) {
        jwt {
            verifier(JwtConfig.instance.verifier)
            validate {
                val claim = it.payload.getClaim(JwtConfig.CLAIM).asInt()
                if (claim != null) {
                    UserIdPrincipalForUser(claim)
                } else {
                    null
                }
            }
            challenge { defaultScheme, realm ->
                call.respond(
                    status = HttpStatusCode.Unauthorized,
                    message = BaseResponse.ErrorResponse(INVALID_AUTHENTICATION_TOKEN)
                )
            }
        }
    }
}