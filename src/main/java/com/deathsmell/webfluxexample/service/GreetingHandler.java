package com.deathsmell.webfluxexample.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> hello (ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Hello, Deathsmell!"));
    }

    public Mono<ServerResponse> main (ServerRequest serverRequest) {
        String name = serverRequest.queryParam("name").orElse("Nobody");
        return ServerResponse
                .ok()
                .render("main", Map.of("name",name));
    }
}
