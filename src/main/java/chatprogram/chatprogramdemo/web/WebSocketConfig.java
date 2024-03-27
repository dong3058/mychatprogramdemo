package chatprogram.chatprogramdemo.web;


import chatprogram.chatprogramdemo.errors.Datas;
import chatprogram.chatprogramdemo.errors.ErrorForm;
import chatprogram.chatprogramdemo.errors.Status;
import chatprogram.chatprogramdemo.service.ContentService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

@Slf4j
@Configuration
@EnableWebSocketMessageBroker
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

    private final ContentService contentService;
    private final Handlers handlers;
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/send");
        registry.enableSimpleBroker("/room");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("*")
                .addInterceptors(handlers)
                .withSockJS();

    }

    @EventListener
    public void onConnectEvent(SessionSubscribeEvent event) {
        StompHeaderAccessor stomp=StompHeaderAccessor.wrap(event.getMessage());
        log.info("header:{}",stomp.getDestination());
        String destination=stomp.getDestination();
        String [] parts=destination.split("/");
        String d=parts[parts.length-1];
        if(contentService.getboards(Long.parseLong(d))==null){
            log.info("boards not extist:{}",contentService.getboards(Long.parseLong(d)));
            throw new RuntimeException("에러발생");
        }

    }


    @EventListener
    public void onDisconnectEvent(SessionDisconnectEvent event) {
        log.info("session disconnect id:{}",event.getSess




