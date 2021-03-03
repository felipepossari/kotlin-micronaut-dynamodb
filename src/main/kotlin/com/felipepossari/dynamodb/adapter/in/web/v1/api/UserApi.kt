package com.felipepossari.dynamodb.adapter.`in`.web.v1.api

import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.request.UserRequest
import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.response.UserResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put

interface UserApi {
    @Post
    fun post(@Body userRequest: UserRequest): UserResponse

    @Put("/{email}")
    fun put(@PathVariable email: String, @Body userRequest: UserRequest): UserResponse

    @Get("/{email}")
    fun getByEmail(@PathVariable email: String): UserResponse

    @Delete("/email")
    fun delete(@PathVariable email: String): UserResponse
}