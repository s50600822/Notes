package com.example.reactivewebclient

import mu.KotlinLogging
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
class BSService(val client: BSClient) {
    private val log = KotlinLogging.logger {}

    fun get(): Flux<String> {
        return Flux.merge(
            client.r1(), client.r1(), client.r1(), client.r2(), client.r2(), client.r2()
        )
    }

    fun getP(): ParallelFlux<String> {
        return Flux.merge(
            client.r1(), client.r1(), client.r1(), client.r2(), client.r2(), client.r2()
        ).parallel()
            .runOn(Schedulers.parallel())
    }

}