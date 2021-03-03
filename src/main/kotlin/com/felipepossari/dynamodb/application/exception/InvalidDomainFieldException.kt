package com.felipepossari.dynamodb.application.exception

import com.felipepossari.dynamodb.application.exception.model.ErrorReason

class InvalidDomainFieldException(private val domainErrors: List<ErrorReason>): BaseException(domainErrors) {
}