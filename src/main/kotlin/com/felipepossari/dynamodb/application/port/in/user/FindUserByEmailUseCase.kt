package com.felipepossari.dynamodb.application.port.`in`.user

import com.felipepossari.dynamodb.application.domain.User

interface FindUserByEmailUseCase {

    fun execute(email: String): User
}