package com.deathsmell.webfluxexample.config;


import com.deathsmell.webfluxexample.service.GreetingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class GreetingRouter {

    @Bean
    public RouterFunction<ServerResponse> route (GreetingHandler greetingHandler) {
        RequestPredicate hello = RequestPredicates
                .GET("/hello")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN));

        RequestPredicate main = RequestPredicates
                .GET("/");

        return RouterFunctions
                .route(hello, greetingHandler::hello)
                .andRoute(main, greetingHandler::main);
    }
}
