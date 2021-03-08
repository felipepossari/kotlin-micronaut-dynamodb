package com.felipepossari.dynamodb.application.domain

import com.felipepossari.dynamodb.application.exception.InvalidDomainFieldException
import com.felipepossari.dynamodb.application.exception.model.ErrorReason
import java.util.*

data class Motorcycle(
        val id: String = "",
        val brand: String = "",
        val model: String = "",
        val manufactureYear: Int = 0,
        val modelYear: Int = 0,
        val color: String = ""
) {
    companion object {
        private const val BRAND_MAX_LENGTH: Int = 256
        private const val MODEL_MAX_LENGTH: Int = 256
        private const val COLOR_MAX_LENGTH: Int = 256
    }

    fun validateFieldsForCreate() {
        var errors = mutableListOf<ErrorReason>()

        validateBrand(brand)?.let { errors.add(it) }
        validateModel(model)?.let { errors.add(it) }
        validateManufactureYear(manufactureYear)?.let { errors.add(it) }
        validateModelYear(modelYear)?.let { errors.add(it) }
        validateColor(color)?.let { errors.add(it) }

        if (errors.isNotEmpty()) {
            throw InvalidDomainFieldException(errors)
        }
    }

    fun validateFieldsForUpdate() {
        var errors = mutableListOf<ErrorReason>()
        validateId(id)?.let { errors.add(it) }
        validateBrand(brand)?.let { errors.add(it) }
        validateModel(model)?.let { errors.add(it) }
        validateManufactureYear(manufactureYear)?.let { errors.add(it) }
        validateModelYear(modelYear)?.let { errors.add(it) }
        validateColor(color)?.let { errors.add(it) }

        if (errors.isNotEmpty()) {
            throw InvalidDomainFieldException(errors)
        }
    }

    private fun validateId(id: String): ErrorReason? {
        if (id.isEmpty()) {
            return ErrorReason.ID_INVALID
        } else {
            try {
                UUID.fromString(id)
            } catch (ex: IllegalArgumentException) {
                return ErrorReason.ID_INVALID
            }
        }
        return null
    }

    private fun validateBrand(brand: String): ErrorReason? =
            if (brand.isEmpty() || brand.length >= BRAND_MAX_LENGTH) {
                ErrorReason.BRAND_INVALID
            } else {
                null
            }

    private fun validateModel(model: String): ErrorReason? =
            if (model.isEmpty() || model.length >= MODEL_MAX_LENGTH) {
                ErrorReason.MODEL_INVALID
            } else {
                null
            }

    private fun validateManufactureYear(manufactureYear: Int): ErrorReason? =
            if (manufactureYear <= 0) {
                ErrorReason.MANUFACTURE_YEAR_INVALID
            } else {
                null
            }

    private fun validateModelYear(modelYear: Int): ErrorReason? =
            if (modelYear <= 0) {
                ErrorReason.MODEL_YEAR_INVALID
            } else {
                null
            }

    private fun validateColor(color: String): ErrorReason? =
            if (color.isEmpty() || color.length >= COLOR_MAX_LENGTH) {
                ErrorReason.COLOR_INVALID
            } else {
                null
            }
}