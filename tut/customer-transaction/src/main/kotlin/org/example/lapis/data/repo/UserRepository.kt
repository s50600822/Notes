package org.example.lapis.data.repo

import org.example.lapis.data.AppUser
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<AppUser, Long> {
    fun findByUsername(username: String): AppUser?
}