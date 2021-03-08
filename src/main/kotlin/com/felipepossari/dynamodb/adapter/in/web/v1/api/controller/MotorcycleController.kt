package com.felipepossari.dynamodb.adapter.`in`.web.v1.api.controller

import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.MotorcycleApi
import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.request.MotorcycleRequest
import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.request.toDomain
import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.response.MotorcycleResponse
import com.felipepossari.dynamodb.application.port.`in`.motorcycle.CreateMotorcycleUseCase
import com.felipepossari.dynamodb.application.port.`in`.motorcycle.UpdateMotorcycleUseCase
import io.micronaut.http.annotation.Controller
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Controller("/users/{email}/motorcycles")
class MotorcycleController(
        private val createMotorcycleUseCase: CreateMotorcycleUseCase,
        private val updateMotorcycleUseCase: UpdateMotorcycleUseCase
) : MotorcycleApi {

    companion object{
        private val logger: Logger = LoggerFactory.getLogger(this::class.qualifiedName)
    }

    override fun post(email: String, motorcycleRequest: MotorcycleRequest): MotorcycleResponse {
        logger.info("Creating motorcycle")
        val bike = createMotorcycleUseCase.execute(email, motorcycleRequest.toDomain())
        return MotorcycleResponse(bike)
    }

    override fun put(email: String, motorcycleId: String, motorcycleRequest: MotorcycleRequest): MotorcycleResponse {
        logger.info("Updating motorcycle")
        val bike = updateMotorcycleUseCase.execute(email, motorcycleRequest.toDomain(motorcycleId))
        return MotorcycleResponse(bike)
    }

    override fun getById(email: String, motorcycleId: String): MotorcycleResponse {
        logger.info("Getting motorcycle by Id")
        TODO("Not yet implemented")
    }

    override fun getById(email: String): List<MotorcycleResponse> {
        logger.info("Getting motorcycles")
        TODO("Not yet implemented")
    }

    override fun delete(email: String) {
        logger.info("Deleting motorcycle")
        TODO("Not yet implemented")
    }
}