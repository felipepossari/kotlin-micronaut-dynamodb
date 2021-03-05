package com.felipepossari.dynamodb.application.port.`in`.user

import com.felipepossari.dynamodb.application.domain.User

interface CreateUserUseCase {

    fun execute(user: User): User
}