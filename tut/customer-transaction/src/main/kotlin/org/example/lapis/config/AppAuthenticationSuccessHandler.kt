package org.example.lapis.config

import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler
import java.io.IOException


class AppAuthenticationSuccessHandler : SimpleUrlAuthenticationSuccessHandler() {
    @Throws(IOException::class, ServletException::class)
    override fun handle(request: HttpServletRequest?, response: HttpServletResponse?, authentication: Authentication?) {
    }
}