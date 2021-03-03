package com.felipepossari.dynamodb

import io.micronaut.runtime.Micronaut.build

fun main(args: Array<String>) {
    build()
            .args(*args)
            .packages("com.felipepossari.dynamodb")
            .start()
}

