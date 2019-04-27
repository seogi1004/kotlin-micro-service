package com.microservices.chapter3

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class Chapter3Application

fun main(args: Array<String>) {
    runApplication<Chapter3Application>(*args)
}