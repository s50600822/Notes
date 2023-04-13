package org.example.lapis.data

import jakarta.persistence.*
import org.springframework.data.annotation.Id

@Entity
data class Role(
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    @ManyToMany(fetch = FetchType.EAGER)
    val permissions: Set<Permission>
)