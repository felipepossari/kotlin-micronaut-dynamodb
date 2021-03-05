package com.felipepossari.dynamodb.application.port.`in`.user

interface DeleteUserUseCase {

    fun execute(email: String)
}