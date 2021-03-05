package com.felipepossari.dynamodb.application.service.user

import com.felipepossari.dynamodb.application.domain.User
import com.felipepossari.dynamodb.application.port.`in`.user.CreateUserUseCase
import com.felipepossari.dynamodb.application.port.out.UserRepositoryPort
import javax.inject.Singleton

@Singleton
class CreateUserService(
        private val userRepositoryPort: UserRepositoryPort,
        private val userDataValidator: UserDataValidator
) : CreateUserUseCase {
    override fun execute(user: User): User {
        user.validateFieldForCreation()
        userDataValidator.validateUserUnique(user)



        userRepositoryPort.create(user)
        return user
    }
}