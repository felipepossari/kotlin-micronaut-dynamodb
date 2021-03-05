package com.felipepossari.dynamodb.application.service.user

import com.felipepossari.dynamodb.application.domain.User
import com.felipepossari.dynamodb.application.exception.ResourceNotFoundException
import com.felipepossari.dynamodb.application.exception.model.ErrorReason
import com.felipepossari.dynamodb.application.port.`in`.user.FindUserByEmailUseCase
import com.felipepossari.dynamodb.application.port.out.UserRepositoryPort
import javax.inject.Singleton

@Singleton
class FindUserByEmailService(
        private val userRepositoryPort: UserRepositoryPort) : FindUserByEmailUseCase {
    override fun execute(email: String): User =
            userRepositoryPort.findByEmail(email) ?: throw ResourceNotFoundException(ErrorReason.RESOURCE_NOT_FOUND)

}