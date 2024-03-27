package chatprogram.chatprogramdemo.controller;

import chatprogram.chatprogramdemo.entity.LoginForm;
import chatprogram.chatprogramdemo.entity.Member;
import chatprogram.chatprogramdemo.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;



    @GetMapping("login")
    public String getlogin(){
        log.info("login get 실행");
        return "login";
    }

    //@ResponseBody
    @PostMapping("login")
    public String logincheck(@Valid @ModelAttribute LoginForm l, HttpServletRequest req){

        Optional<Member> m=loginService.logincheck(l);

        if(m.isPresent()){

        }


        HttpSession session=req.getSession();
        session.setAttribute("id",l.getId());

        //return "ok";
        return "redirect:/home";
    }

    @ResponseBody
    public String loginout( HttpServletRequest req){
        HttpSession session=req.getSession(false);


        if(session!=null){
            session.invalidate();;
        }


        return "ok";
    }
}
