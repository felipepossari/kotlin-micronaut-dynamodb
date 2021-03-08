package com.felipepossari.dynamodb.adapter.`in`.web.v1.api.controller

import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.MotorcycleApi
import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.request.MotorcycleRequest
import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.request.toDomain
import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.response.MotorcycleResponse
import com.felipepossari.dynamodb.application.port.`in`.motorcycle.CreateMotorcycleUseCase
import io.micronaut.http.annotation.Controller

@Controller("/users/{email}/motorcycles")
class MotorcycleController(
        private val createMotorcycleUseCase: CreateMotorcycleUseCase
) : MotorcycleApi {
    override fun post(email: String, motorcycleRequest: MotorcycleRequest): MotorcycleResponse {
        val bike = createMotorcycleUseCase.execute(email, motorcycleRequest.toDomain())
        return MotorcycleResponse(bike)
    }

    override fun put(email: String, motorcycleId: String, motorcycleRequest: MotorcycleRequest): MotorcycleResponse {
        TODO("Not yet implemented")
    }

    override fun getById(email: String, motorcycleId: String): MotorcycleResponse {
        TODO("Not yet implemented")
    }

    override fun getById(email: String): List<MotorcycleResponse> {
        TODO("Not yet implemented")
    }

    override fun delete(email: String) {
        TODO("Not yet implemented")
    }
}