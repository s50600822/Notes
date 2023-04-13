package org.example.lapis.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
//https://docs.spring.io/spring-security/reference/servlet/configuration/kotlin.html
//https://github.com/spring-projects/spring-security-samples/tree/main/servlet/spring-boot/kotlin/hello-security/src/test/kotlin/org/springframework/security
//class SecurityConfig(private val userService: UserService) {

class SecurityConfig() {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests()
            .requestMatchers("/css/**").permitAll()
            .requestMatchers("/hi").permitAll()
            .requestMatchers("/hiadmin").hasAuthority("ROLE_ADMIN")
            .requestMatchers("/user/**").hasAuthority("ROLE_USER")
            .and().httpBasic()
        return http.build()
    }


    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun userDetailsService(): UserDetailsService {
        //curl -X GET http://localhost:8080/hiadmin   -H 'Authorization: Basic YWRtaW46YWRtaW4xMjM='
        val user = User.builder()
            .username("admin")
            .password(passwordEncoder().encode("admin123"))
            .authorities("ROLE_ADMIN")
            .build()
        return InMemoryUserDetailsManager(user)
    }
}