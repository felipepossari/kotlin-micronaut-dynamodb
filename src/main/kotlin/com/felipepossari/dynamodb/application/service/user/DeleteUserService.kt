package com.felipepossari.dynamodb.application.service.user

import com.felipepossari.dynamodb.application.exception.ResourceNotFoundException
import com.felipepossari.dynamodb.application.exception.model.ErrorReason
import com.felipepossari.dynamodb.application.port.`in`.user.DeleteUserUseCase
import com.felipepossari.dynamodb.application.port.out.UserRepositoryPort
import javax.inject.Singleton

@Singleton
class DeleteUserService(
        private val userRepositoryPort: UserRepositoryPort
) : DeleteUserUseCase {
    override fun execute(email: String) {
        userRepositoryPort.findByEmail(email)
                ?: throw ResourceNotFoundException(ErrorReason.RESOURCE_NOT_FOUND)
        userRepositoryPort.delete(email)
    }
}