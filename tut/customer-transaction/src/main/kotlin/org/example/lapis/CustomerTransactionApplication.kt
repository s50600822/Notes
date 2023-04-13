package org.example.lapis

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class CustomerTransactionApplication

fun main(args: Array<String>) {
	SpringApplication.run(CustomerTransactionApplication::class.java, *args)
}
