package org.example.lapis.data

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id

@Entity
data class Customer(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null,
    var name: String,
    var email: String,
    var active: Boolean = true,
)