package com.microservices.chapter6discoveryserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class Chapter6DiscoveryServerApplication

fun main(args: Array<String>) {
    runApplication<Chapter6DiscoveryServerApplication>(*args)
}
