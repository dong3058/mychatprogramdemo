package chatprogram.chatprogramdemo.controller;


import chatprogram.chatprogramdemo.entity.*;
import chatprogram.chatprogramdemo.errors.Datas;
import chatprogram.chatprogramdemo.errors.ErrorForm;
import chatprogram.chatprogramdemo.errors.Status;
import chatprogram.chatprogramdemo.service.ContentService;
import chatprogram.chatprogramdemo.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.WebSocketMessageBrokerStats;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import javax.swing.text.AbstractDocument;
import javax.xml.stream.events.Comment;
import java.net.http.WebSocket;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@Slf4j
public class WebSocketController {


    private final ContentService service;
    private final MemberService memberService;
    private final ContentService contentService;
    private final SimpMessagingTemplate template;
    /*@MessageMapping("/{userid}/{roomid}")
    @SendTo("/room/{roomid}")
    public CommentToShow livechatservice(@DestinationVariable(value="userid") String userid,@DestinationVariable(value="roomid") Long roomid,@Payload CommentToAssign c){
        log.info("userid test inlogtext:{}",c.getMaintext());

        Comments comments=service.makecommentsforwebsocket(c,userid,roomid);



        return new CommentToShow(comments.getId(),userid,comments.getMaintext(),comments.getDate());

    }*/


//SimpMessageHeaderAccessor messageHeaderAccessor 애써도 되긴하는대 애는 범용성이큰거고
    //우리는 stomp를 사요하므로 딴걸써보자
    @MessageMapping("/{roomid}")
    //@SendTo("/room/{roomid}")
    public  void livechatservice(@DestinationVariable(value = "roomid") Long roomid, String s, StompHeaderAccessor messageHeaderAccessor ){



        HttpSession session=(HttpSession) messageHeaderAccessor.getSessionAttributes().get("session");
        String userid=(String) session.getAttribute("id");
        log.info("session id another:{}",messageHeaderAccessor.getSessionId());
        log.info("session id:{}",session.getId());
        log.info("session value:{}",userid);

        /*if(contentService.checkuserinboards(userid,roomid)){



        }*/
        System.out.println("/sub/room/"+roomid);
        template.convertAndSend("/room/"+roomid,s);
        //return s;

    }



    }



