package com.felipepossari.dynamodb.adapter.`in`.web.v1.api.response

import com.felipepossari.dynamodb.application.domain.Motorcycle

data class MotorcycleResponse(
        val id: String,
        val brand: String,
        val model: String,
        val manufactureYear: Int,
        val modelYear: Int,
        val color: String
) {
    constructor(motorcycle: Motorcycle) : this(
            id = motorcycle.id,
            brand = motorcycle.brand,
            model = motorcycle.model,
            manufactureYear = motorcycle.manufactureYear,
            modelYear = motorcycle.modelYear,
            color = motorcycle.color
    ) {
    }
}
