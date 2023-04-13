package org.example.lapis.data

import jakarta.persistence.*
import org.springframework.data.annotation.Id


@Entity
class AppUser {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null
    private val username: String? = null
    private val email: String? = null
    private val password: String? = null
    private var createdEpoch: Long = System.currentTimeMillis()

    @ManyToMany
    private val roles: Set<Role> = emptySet()
}