package net.simplifiedcoding.config

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.jackson.*
import net.simplifiedcoding.data.db.DatabaseFactory
import net.simplifiedcoding.di.RepositoryProvider
import net.simplifiedcoding.routes.auth.authRoutes
import net.simplifiedcoding.routes.story.storyRoutes
import net.simplifiedcoding.routes.user.userRoutes

fun configureDatabase() {
    DatabaseFactory.init()
}

fun Application.configureContentNegotiation() {
    install(ContentNegotiation) {
        jackson()
    }
}

fun Application.configureRouting(){
    authRoutes(RepositoryProvider.provideAuthRepository())
    userRoutes(RepositoryProvider.provideUserRepository())
    storyRoutes(RepositoryProvider.provideStoryRepository())
}