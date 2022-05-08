package net.simplifiedcoding

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import net.simplifiedcoding.config.configureContentNegotiation
import net.simplifiedcoding.config.configureDatabase
import net.simplifiedcoding.config.configureRouting
import net.simplifiedcoding.config.configureStatusPages
import net.simplifiedcoding.security.configureSecurity

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        configureDatabase()
        configureContentNegotiation()
        configureStatusPages()
        configureSecurity()
        configureRouting()
    }.start(wait = true)
}
