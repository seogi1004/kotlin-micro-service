package com.microservices.chapter3

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CustomerController {
    @Autowired
    private lateinit var customerService: CustomerService

    @GetMapping(value = [ "/customer/{id}" ])
    fun getCustomer(@PathVariable id : Int): ResponseEntity<Customer?> {
        val customer = customerService.getCustomer(id) ?:
                throw CustomerNotFoundException("customer '$id' not found")
        return ResponseEntity(customer, HttpStatus.OK)
    }

    @RequestMapping(value = [ "/customers" ], method = [ RequestMethod.GET ])
    fun getCustomers(@RequestParam(required = false, defaultValue = "") nameFilter: String) =
            customerService.searchCustomers(nameFilter)

    @RequestMapping(value = [ "/customer/" ], method = [ RequestMethod.POST ])
    fun createCustomer(@RequestBody customer: Customer): ResponseEntity<Unit?> {
        customerService.createCustomer(customer)
        return ResponseEntity(null, HttpStatus.CREATED)
    }

    @RequestMapping(value = [ "/customer/{id}" ], method = [ RequestMethod.DELETE ])
    fun deleteCustomer(@PathVariable id: Int): ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND
        if (customerService.getCustomer(id) != null) {
            customerService.deleteCustomer(id)
            status = HttpStatus.OK
        }
        return ResponseEntity(Unit, status)
    }

    @RequestMapping(value = [ "/customer/{id}" ], method = [ RequestMethod.PUT ])
    fun updateCustomer(@PathVariable id: Int, @RequestBody customer: Customer): ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND
        if (customerService.getCustomer(id) != null) {
            customerService.updateCustomer(id, customer)
            status = HttpStatus.ACCEPTED
        }
        return ResponseEntity(Unit, status)
    }
}