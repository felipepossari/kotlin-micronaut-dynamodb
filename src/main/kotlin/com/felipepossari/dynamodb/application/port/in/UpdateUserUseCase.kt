package com.felipepossari.dynamodb.application.port.`in`

import com.felipepossari.dynamodb.application.domain.User

interface UpdateUserUseCase {

    fun execute(email: String, user: User): User
}