package com.felipepossari.dynamodb.application.service.user

import com.felipepossari.dynamodb.application.domain.User
import com.felipepossari.dynamodb.application.exception.ResourceNotFoundException
import com.felipepossari.dynamodb.application.exception.model.ErrorReason
import com.felipepossari.dynamodb.application.port.`in`.user.UpdateUserUseCase
import com.felipepossari.dynamodb.application.port.out.UserRepositoryPort
import javax.inject.Singleton

@Singleton
class UpdateUserService(
        private val userRepositoryPort: UserRepositoryPort,
        private val userDataValidator: UserDataValidator
) : UpdateUserUseCase {
    override fun execute(email: String, user: User): User {
        user.validateFieldForUpdate()
        val currentUser = retrieveUser(email)
        val updatedUser = currentUser.copy(
                name = user.name,
                phone = user.phone,
                password = user.password
        )
        userRepositoryPort.update(updatedUser)
        return user
    }

    private fun retrieveUser(email: String): User =
            userRepositoryPort.findByEmail(email) ?: throw ResourceNotFoundException(ErrorReason.RESOURCE_NOT_FOUND)
}