package com.felipepossari.dynamodb.application.service

import com.felipepossari.dynamodb.application.domain.User
import com.felipepossari.dynamodb.application.port.`in`.CreateUserUseCase
import javax.inject.Singleton

@Singleton
class CreateUserService : CreateUserUseCase {
    override fun execute(user: User): User {
        return user
    }
}