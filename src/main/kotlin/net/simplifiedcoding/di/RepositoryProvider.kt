package net.simplifiedcoding.di

import net.simplifiedcoding.data.repository.auth.AuthRepository
import net.simplifiedcoding.data.repository.auth.AuthRepositoryImpl
import net.simplifiedcoding.data.repository.story.StoryRepository
import net.simplifiedcoding.data.repository.story.StoryRepositoryImpl
import net.simplifiedcoding.data.repository.user.UserRepository
import net.simplifiedcoding.data.repository.user.UserRepositoryImpl
import net.simplifiedcoding.data.service.auth.AuthServiceImpl
import net.simplifiedcoding.data.service.story.StoryServiceImpl
import net.simplifiedcoding.data.service.user.UserServiceImpl

object RepositoryProvider {
    fun provideAuthRepository(): AuthRepository = AuthRepositoryImpl(AuthServiceImpl())
    fun provideUserRepository(): UserRepository = UserRepositoryImpl(UserServiceImpl())
    fun provideStoryRepository(): StoryRepository = StoryRepositoryImpl(StoryServiceImpl())
}