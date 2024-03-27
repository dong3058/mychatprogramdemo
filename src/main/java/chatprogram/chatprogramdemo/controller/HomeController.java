package chatprogram.chatprogramdemo.controller;


import chatprogram.chatprogramdemo.entity.MessageTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class HomeController {


    @GetMapping("home")
    public String showhome(){
        log.info("home controller get test");
        return "home";
    }

    @PostMapping("/chat")
    public String homes(@ModelAttribute MessageTest messageTest){
        log.info("messgetest:{}",messageTest.getChatroomid());

        return "chat";
    }

}
