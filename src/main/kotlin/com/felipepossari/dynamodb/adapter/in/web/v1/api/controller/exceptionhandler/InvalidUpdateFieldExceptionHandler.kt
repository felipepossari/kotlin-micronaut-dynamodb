package com.felipepossari.dynamodb.adapter.`in`.web.v1.api.controller.exceptionhandler

import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.controller.exceptionhandler.model.Error
import com.felipepossari.dynamodb.application.exception.InvalidUpdateFieldException
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpResponseFactory
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Produces
@Singleton
class InvalidUpdateFieldExceptionHandler : ExceptionHandler<InvalidUpdateFieldException, HttpResponse<*>> {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.qualifiedName)
    }

    override fun handle(request: HttpRequest<*>, exception: InvalidUpdateFieldException): HttpResponse<*> {
        logger.warn("Invalid update email exception handler executed")
        return HttpResponseFactory.INSTANCE
                .status(HttpStatus.CONFLICT, exception.errors.map { Error(code = it.code, message = it.message) })
    }
}