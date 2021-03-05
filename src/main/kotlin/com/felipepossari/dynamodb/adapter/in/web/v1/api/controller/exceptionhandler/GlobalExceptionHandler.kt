package com.felipepossari.dynamodb.adapter.`in`.web.v1.api.controller.exceptionhandler

import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.controller.exceptionhandler.model.Error
import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.controller.exceptionhandler.model.ErrorResponse
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Produces
@Singleton
class GlobalExceptionHandler : ExceptionHandler<Exception, HttpResponse<*>> {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.qualifiedName)
    }

    override fun handle(request: HttpRequest<*>, exception: Exception): HttpResponse<*> {
        logger.error("Global exception handler executed", exception)
        return HttpResponse.serverError(buildErrorResponse(exception))
    }

    private fun buildErrorResponse(exception: Exception): ErrorResponse =
            ErrorResponse(listOf(buildError(exception)))

    private fun buildError(exception: Exception) =
            Error(HttpStatus.INTERNAL_SERVER_ERROR.code.toString(), exception.message!!)
}