package com.felipepossari.dynamodb.application.service

import com.felipepossari.dynamodb.application.domain.User
import com.felipepossari.dynamodb.application.exception.InvalidUpdateFieldException
import com.felipepossari.dynamodb.application.exception.ResourceAlreadyExistsException
import com.felipepossari.dynamodb.application.exception.ResourceNotFoundException
import com.felipepossari.dynamodb.application.exception.model.ErrorReason
import com.felipepossari.dynamodb.application.port.out.UserRepositoryPort
import javax.inject.Singleton

@Singleton
class UserDataValidator(private val userRepositoryPort: UserRepositoryPort) {

    fun validateUserUnique(user: User) {
        userRepositoryPort.findByEmail(user.email)?.let {
            throw ResourceAlreadyExistsException(ErrorReason.RESOURCE_ALREADY_EXISTS)
        }
    }

    fun validateUserUpdate(email: String, user: User) {
        val user = userRepositoryPort.findByEmail(user.email)
                ?: throw ResourceNotFoundException(ErrorReason.RESOURCE_NOT_FOUND)
        if(user.email != email){
            throw InvalidUpdateFieldException(ErrorReason.EMAIL_ALREADY_USED)
        }
    }
}