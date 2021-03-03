package com.felipepossari.dynamodb.application.exception.model

enum class ErrorReason(val code: String, val message: String) {

    EMAIL_INVALID("001", "Email cannot be null or bigger than 255 characters"),
    NAME_INVALID("002", "Name cannot be null or bigger than 255 characters"),
    PHONE_INVALID("003", "Phone cannot be null or bigger than 25 characters"),
    PASSWORD_INVALID("004", "Password cannot be null"),

    RESOURCE_ALREADY_EXISTS("010", "Resource already exists")
}