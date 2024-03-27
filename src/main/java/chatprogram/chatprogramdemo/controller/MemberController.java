package chatprogram.chatprogramdemo.controller;


import chatprogram.chatprogramdemo.entity.MemberForAssign;
import chatprogram.chatprogramdemo.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;


    @GetMapping("members/add")
    public String addmemberget(){

        return "member";

    }

    @PostMapping("members/add")
    //@ResponseBody
    public String addmember(@Valid @ModelAttribute MemberForAssign member){
        log.info("member:{}{}{}",member.getEmail(),member.getUsername(),member.getPassword());
        memberService.save(member);


        return "redirect:/login";

    }


}
