package com.microservices.chapter5

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class Chapter05Application

fun main(args: Array<String>) {
    runApplication<Chapter05Application>(*args)
}