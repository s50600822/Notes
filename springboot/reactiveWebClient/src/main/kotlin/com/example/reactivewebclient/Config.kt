package com.example.reactivewebclient

import io.netty.channel.ChannelOption
import io.netty.handler.timeout.ReadTimeoutHandler
import io.netty.handler.timeout.WriteTimeoutHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import java.time.Duration
import java.util.concurrent.TimeUnit
import reactor.netty.http.brave.ReactorNettyHttpTracing
import reactor.netty.http.client.HttpClient


@Configuration
class Config {


    @Bean
    fun webClient(httpTracing: brave.http.HttpTracing, webclientB: WebClient.Builder): WebClient {
        val httpClient: HttpClient = HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
            .responseTimeout(Duration.ofMillis(5000))
            .doOnConnected { conn ->
                conn.addHandlerLast(ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                    .addHandlerLast(WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS))
            }
        //warm the fuck up
        httpClient.warmup().block()
        val webClient: WebClient = webclientB
            .clientConnector(ReactorClientHttpConnector(httpClient))
            .baseUrl("https://data.nsw.gov.au/data/api/3/action/datastore_search")
            .build()
        return webClient
    }

}