package com.example.reactivewebclient

import mu.KotlinLogging
import org.springframework.cloud.sleuth.annotation.NewSpan
import org.springframework.http.HttpMethod.GET
import org.springframework.http.MediaType
import org.springframework.http.MediaType.*
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.ParallelFlux
import reactor.core.scheduler.Schedulers


@Service
class BSClient(val webClient: WebClient) {
    private val log = KotlinLogging.logger {}

    @NewSpan
    fun r1(): Flux<String> {
        return webClient.method(GET)
            .contentType(APPLICATION_JSON)
            .body(BodyInserters.fromValue("{\"resource_id\": \"2776dbb8-f807-4fb2-b1ed-184a6fc2c8aa\", \"limit\": 5, \"q\": \"jones\" }"))
            .retrieve()
            .bodyToFlux(String::class.java)
            .onErrorResume { handleErr(it) }
    }

    @NewSpan
    fun r2(): Flux<String> {
        return webClient.method(GET)
            .contentType(APPLICATION_JSON)
            .body(BodyInserters.fromValue("{\"resource_id\": \"2776dbb8-f807-4fb2-b1ed-184a6fc2c8aa\", \"limit\": 5, \"q\": \"jones\" }"))
            .retrieve()
            .bodyToFlux(String::class.java)
            .onErrorResume { handleErr(it) }
    }


    private fun handleErr(t: Throwable): Mono<String> {
        log.error("MOTHERFUCVKER", t)
        return Mono.just("BLEEP")
    }
}