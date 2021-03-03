package com.felipepossari.dynamodb.application.service

import com.felipepossari.dynamodb.application.domain.User
import com.felipepossari.dynamodb.application.exception.model.ErrorReason
import com.felipepossari.dynamodb.application.exception.ResourceAlreadyExistsException
import com.felipepossari.dynamodb.application.port.out.UserRepositoryPort
import javax.inject.Singleton

@Singleton
class UserDataValidator(private val userRepositoryPort: UserRepositoryPort) {

    fun validateUserUnique(user: User) {
        userRepositoryPort.findByEmail(user.email)?.let {
            throw ResourceAlreadyExistsException(ErrorReason.RESOURCE_ALREADY_EXISTS)
        }
    }
}