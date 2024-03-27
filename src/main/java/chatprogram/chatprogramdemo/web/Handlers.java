package chatprogram.chatprogramdemo.web;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.server.HandshakeHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.security.Principal;
import java.util.List;
import java.util.Map;
@Slf4j
@Component
public class Handlers implements HandshakeInterceptor {
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {

        ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
        HttpSession httpSession = servletRequest.getServletRequest().getSession(false);
        //위의 코드는 클라이언트가 가진 세션이 그대로 들어오는지 체크하는것.
        //실행해보면 클라가 가진 세션 그대로 들어온다 나이스!
        log.info("sesion check in handler for session exist:{}",httpSession);
        log.info("session id check:{}",httpSession.getId());
        log.info("session check in handler:{}",httpSession.getAttribute("id"));

        if(attributes.get("session")==null){
           log.info("attributes 에 session 키로 만들어진 값이 없습니다");
        }
        attributes.put("session",httpSession);

        log.info("attributes:{}",attributes.get("session"));
        //attributs에 넣어서 클라가 가진 세션을 추후에 stomp통신에서 쓸수있게 만든다.




        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

    }


}
