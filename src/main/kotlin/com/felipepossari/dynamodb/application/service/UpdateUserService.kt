package com.felipepossari.dynamodb.application.service

import com.felipepossari.dynamodb.application.domain.User
import com.felipepossari.dynamodb.application.exception.ResourceNotFoundException
import com.felipepossari.dynamodb.application.exception.model.ErrorReason
import com.felipepossari.dynamodb.application.port.`in`.UpdateUserUseCase
import com.felipepossari.dynamodb.application.port.out.UserRepositoryPort
import javax.inject.Singleton

@Singleton
class UpdateUserService(
        private val userRepositoryPort: UserRepositoryPort,
        private val userDataValidator: UserDataValidator
) : UpdateUserUseCase {
    override fun execute(email: String, user: User): User {
        user.validateFields()
        userDataValidator.validateUserUpdate(email, user)
        val currentUser = retrieveUser(email)
        val updatedUser = currentUser.copy(
                email = user.email,
                name = user.name,
                phone = user.phone,
                password = user.password
        )
        userRepositoryPort.save(updatedUser)
        return user
    }

    private fun retrieveUser(email: String): User =
            userRepositoryPort.findByEmail(email) ?: throw ResourceNotFoundException(ErrorReason.RESOURCE_NOT_FOUND)
}