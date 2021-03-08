package com.felipepossari.dynamodb.application.port.`in`.motorcycle

interface DeleteMotorcycleUseCase {

    fun execute(email: String, motorcycleId: String)
}