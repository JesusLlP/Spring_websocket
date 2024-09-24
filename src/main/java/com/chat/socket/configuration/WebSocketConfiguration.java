package com.chat.socket.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer{
    
    @Override //nos permite habilitar un broker para la comunicacion entre CLIENTE - FRONT - BACK
    public void configureMessageBroker(MessageBrokerRegistry registry){
        //WebSocketMessageBrokerConfigurer.super.configureMessageBroker(registry);
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }
    @Override//registrar endpoints
    public void registerStompEndpoints(StompEndpointRegistry registry){
        //WebSocketMessageBrokerConfigurer.super.registerStompEndpoints(registry);
        registry.addEndpoint("/chat-socket")
                .setAllowedOrigins("/http://localhost:4200")
                .withSockJS();
    }
    
}
