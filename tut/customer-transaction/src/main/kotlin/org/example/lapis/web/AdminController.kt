package org.example.lapis.web

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class AdminController {
    @GetMapping("/hiadmin")
    @PreAuthorize("hasRole('ADMIN')")
    fun hiadmin(): List<String> {
        return listOf("hi admin")
    }


    @GetMapping("/hi")
    fun hi(): List<String> {
        return listOf("hi")
    }
}