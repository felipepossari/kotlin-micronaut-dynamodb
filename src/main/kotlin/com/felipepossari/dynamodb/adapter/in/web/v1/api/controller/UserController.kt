package com.felipepossari.dynamodb.adapter.`in`.web.v1.api.controller

import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.UserApi
import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.request.UserRequest
import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.request.toDomain
import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.response.UserResponse
import com.felipepossari.dynamodb.application.port.`in`.CreateUserUseCase
import io.micronaut.http.annotation.Controller
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Controller("/users")
class UserController(
        private val createUserUseCase: CreateUserUseCase
) : UserApi {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.qualifiedName)
    }

    override fun post(userRequest: UserRequest): UserResponse {
        val user = createUserUseCase.execute(userRequest.toDomain())
        return UserResponse(user)
    }

    override fun update(userRequest: UserRequest): UserResponse {
        TODO("Not yet implemented")
    }

    override fun getByEmail(email: String): UserResponse {
        TODO("Not yet implemented")
    }

    override fun delete(email: String): UserResponse {
        TODO("Not yet implemented")
    }

}