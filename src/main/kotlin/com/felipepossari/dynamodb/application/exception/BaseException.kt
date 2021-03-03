package com.felipepossari.dynamodb.application.exception

import com.felipepossari.dynamodb.application.exception.model.ErrorReason

open class BaseException(val errors: List<ErrorReason>) : Exception() {
}