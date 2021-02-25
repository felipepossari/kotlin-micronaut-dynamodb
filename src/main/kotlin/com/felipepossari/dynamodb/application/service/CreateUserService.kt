package com.felipepossari.dynamodb.application.service

import com.felipepossari.dynamodb.application.domain.User
import com.felipepossari.dynamodb.application.port.`in`.CreateUserUseCase
import com.felipepossari.dynamodb.application.port.out.UserRepositoryPort
import javax.inject.Singleton

@Singleton
class CreateUserService(
        private val userRepositoryPort: UserRepositoryPort
) : CreateUserUseCase {
    override fun execute(user: User): User {
        userRepositoryPort.save(user)
        return user
    }
}