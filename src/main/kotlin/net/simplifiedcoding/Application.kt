package net.simplifiedcoding

import io.ktor.application.*
import io.ktor.server.tomcat.*
import net.simplifiedcoding.config.configureContentNegotiation
import net.simplifiedcoding.config.configureDatabase
import net.simplifiedcoding.config.configureRouting
import net.simplifiedcoding.config.configureStatusPages
import net.simplifiedcoding.security.configureSecurity

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    configureDatabase()
    configureContentNegotiation()
    configureStatusPages()
    configureSecurity()
    configureRouting()
}
