package com.microservices.chapter9

import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class CustomerServiceTest {
    @Autowired
    lateinit var customerService: CustomerService

    @Test
    fun getAllCustomers() {
        val customers = customerService.getAllCustomers()
        assertEquals(customers.size, 3)
    }

    @Test
    fun getCustomer() {
        val customer = customerService.getCustomer(1)
        assertNotNull(customer)
        assertEquals(customer?.name, "Kotlin")
    }
}