package com.felipepossari.dynamodb.application.port.`in`

interface DeleteUserUseCase {

    fun execute(email: String)
}