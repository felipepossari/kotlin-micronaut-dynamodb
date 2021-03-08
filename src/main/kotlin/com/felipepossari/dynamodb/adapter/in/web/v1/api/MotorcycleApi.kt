package com.felipepossari.dynamodb.adapter.`in`.web.v1.api

import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.request.MotorcycleRequest
import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.response.MotorcycleResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put

interface MotorcycleApi {

    @Post
    fun post(@PathVariable email: String, @Body motorcycleRequest: MotorcycleRequest): MotorcycleResponse

    @Put("{motorcycleId}")
    fun put(@PathVariable email: String,
            @PathVariable motorcycleId: String,
            @Body motorcycleRequest: MotorcycleRequest): MotorcycleResponse

    @Get("{motorcycleId}")
    fun getById(@PathVariable email: String,
                @PathVariable motorcycleId: String): MotorcycleResponse

    @Get
    fun getById(@PathVariable email: String): List<MotorcycleResponse>

    @Delete("{motorcycleId}")
    fun delete(@PathVariable email: String,
               @PathVariable motorcycleId: String)
}