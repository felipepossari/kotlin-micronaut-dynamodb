package com.felipepossari.dynamodb.application.service

import com.felipepossari.dynamodb.application.domain.User
import com.felipepossari.dynamodb.application.port.`in`.CreateUserUseCase
import com.felipepossari.dynamodb.application.port.out.UserRepositoryPort
import javax.inject.Singleton

@Singleton
class CreateUserService(
        private val userRepositoryPort: UserRepositoryPort,
        private val userDataValidator: UserDataValidator
) : CreateUserUseCase {
    override fun execute(user: User): User {
        user.validateFields()
        userDataValidator.validateUserUnique(user)



        userRepositoryPort.save(user)
        return user
    }
}