package com.felipepossari.dynamodb

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.felipepossari.dynamodb")
		.start()
}

