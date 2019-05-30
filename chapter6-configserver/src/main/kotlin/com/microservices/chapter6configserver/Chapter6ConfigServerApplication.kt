package com.microservices.chapter6configserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
class Chapter6ConfigServerApplication

fun main(args: Array<String>) {
    runApplication<Chapter6ConfigServerApplication>(*args)
}
