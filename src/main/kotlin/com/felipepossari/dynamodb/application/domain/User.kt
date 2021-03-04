package com.felipepossari.dynamodb.application.domain

import com.felipepossari.dynamodb.application.exception.InvalidDomainFieldException
import com.felipepossari.dynamodb.application.exception.model.ErrorReason

data class User(
        val email: String = "",
        val name: String = "",
        val phone: String = "",
        val password: String = ""
) {
    companion object {
        private const val EMAIL_MAX_LENGHT: Int = 256
        private const val NAME_MAX_LENGHT: Int = 256
        private const val PHONE_MAX_LENGHT: Int = 256
        private const val PASSWORD_MAX_LENGHT: Int = 256
    }

    fun validateFieldForCreation() {
        var errors = mutableListOf<ErrorReason>()
        validateEmail(email)?.let { errors.add(it) }
        validateName(name)?.let { errors.add(it) }
        validatePhone(phone)?.let { errors.add(it) }
        validatePassword(password)?.let { errors.add(it) }

        if (errors.isNotEmpty()) {
            throw InvalidDomainFieldException(errors)
        }
    }

    fun validateFieldForUpdate() {
        var errors = mutableListOf<ErrorReason>()
        validateName(name)?.let { errors.add(it) }
        validatePhone(phone)?.let { errors.add(it) }
        validatePassword(password)?.let { errors.add(it) }

        if (errors.isNotEmpty()) {
            throw InvalidDomainFieldException(errors)
        }
    }

    private fun validateEmail(email: String): ErrorReason? =
            if (email.isEmpty() || email.length >= EMAIL_MAX_LENGHT) {
                ErrorReason.EMAIL_INVALID
            } else {
                null
            }

    private fun validateName(name: String): ErrorReason? =
            if (name.isEmpty() || name.length >= NAME_MAX_LENGHT) {
                ErrorReason.NAME_INVALID
            } else {
                null
            }

    private fun validatePhone(phone: String): ErrorReason? =
            if (phone.isEmpty() || phone.length >= PHONE_MAX_LENGHT) {
                ErrorReason.PHONE_INVALID
            } else {
                null
            }

    private fun validatePassword(password: String): ErrorReason? =
            if (password.isEmpty() || password.length >= PASSWORD_MAX_LENGHT) {
                ErrorReason.PASSWORD_INVALID
            } else {
                null
            }
}