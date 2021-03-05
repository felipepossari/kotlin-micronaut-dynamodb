package com.felipepossari.dynamodb.application.service

import com.felipepossari.dynamodb.application.exception.ResourceNotFoundException
import com.felipepossari.dynamodb.application.exception.model.ErrorReason
import com.felipepossari.dynamodb.application.port.`in`.DeleteUserUseCase
import com.felipepossari.dynamodb.application.port.out.UserRepositoryPort
import javax.inject.Singleton

@Singleton
class DeleteUserService(
        private val userRepositoryPort: UserRepositoryPort
) : DeleteUserUseCase {
    override fun execute(email: String) {
        val user = userRepositoryPort.findByEmail(email)
                ?: throw ResourceNotFoundException(ErrorReason.RESOURCE_NOT_FOUND)
        userRepositoryPort.delete(email)
    }
}