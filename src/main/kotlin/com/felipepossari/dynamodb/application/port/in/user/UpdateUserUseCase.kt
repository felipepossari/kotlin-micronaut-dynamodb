package com.felipepossari.dynamodb.application.port.`in`.user

import com.felipepossari.dynamodb.application.domain.User

interface UpdateUserUseCase {

    fun execute(email: String, user: User): User
}