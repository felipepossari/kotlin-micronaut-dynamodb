package com.felipepossari.dynamodb.application.port.`in`

import com.felipepossari.dynamodb.application.domain.User

interface DeleteUserUseCase {

    fun execute(email: User)
}