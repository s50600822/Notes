package com.example.reactivewebclient

import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory
import org.springframework.boot.web.embedded.netty.NettyServerCustomizer
import org.springframework.boot.web.server.WebServerFactoryCustomizer
import org.springframework.stereotype.Component
import reactor.netty.http.brave.ReactorNettyHttpTracing
import reactor.netty.http.server.HttpServer


//@Component
//class NettyCustomizer : WebServerFactoryCustomizer<NettyReactiveWebServerFactory> {
//    override fun customize(factory: NettyReactiveWebServerFactory) {
//        factory.addServerCustomizers(NettyServerCustomizer { httpServer: HttpServer ->
//            httpServer.metrics(true) { x -> x }
//
//            val reactorNettyHttpTracing = ReactorNettyHttpTracing.create(httpTracing)
//            val decoratedServer = reactorNettyHttpTracing.decorateHttpServer(httpServer)
//        })
//    }
//}