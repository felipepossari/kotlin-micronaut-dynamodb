package com.felipepossari.dynamodb.adapter.`in`.web.v1.api

import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.request.UserCreateRequest
import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.request.UserUpdateRequest
import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.response.UserResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put

interface UserApi {
    @Post
    fun post(@Body userRequest: UserCreateRequest): HttpResponse<UserResponse>

    @Put("/{email}")
    fun put(@PathVariable email: String, @Body userRequest: UserUpdateRequest): HttpResponse<UserResponse>

    @Get("/{email}")
    fun getByEmail(@PathVariable email: String): HttpResponse<UserResponse>

    @Delete("/{email}")
    fun delete(@PathVariable email: String): HttpResponse<*>
}