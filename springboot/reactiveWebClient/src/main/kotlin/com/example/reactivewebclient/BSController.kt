package com.example.reactivewebclient

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BSController(val svc: BSService) {
    @GetMapping("/bs")
    fun handle() = svc.get()


    @GetMapping("/bsp")
    fun handleP() = svc.getP()
}