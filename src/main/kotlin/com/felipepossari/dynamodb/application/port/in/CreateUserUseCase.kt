package com.felipepossari.dynamodb.application.port.`in`

import com.felipepossari.dynamodb.application.domain.User

interface CreateUserUseCase {

    fun execute(user: User): User
}