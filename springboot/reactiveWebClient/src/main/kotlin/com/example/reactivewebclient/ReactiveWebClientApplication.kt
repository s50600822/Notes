package com.example.reactivewebclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveWebClientApplication

fun main(args: Array<String>) {
    runApplication<ReactiveWebClientApplication>(*args)
}
