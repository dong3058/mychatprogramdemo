package chatprogram.chatprogramdemo.controller;


import chatprogram.chatprogramdemo.entity.*;
import chatprogram.chatprogramdemo.reponse.ApiResponse;
import chatprogram.chatprogramdemo.reponse.Status;
import chatprogram.chatprogramdemo.service.ContentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@Slf4j
public class ContentController {

    private final ContentService service;

    @PostMapping("/saveboard")
    @ResponseBody
    public String makeborad(@ModelAttribute Boards b,HttpServletRequest req){

        log.info("{}",b.getTitle());
        service.makeboards(b,req);
        return "ok";

    }

    @PostMapping("/savecomment/{board_id}")
    @ResponseBody
    public String makecomment(@ModelAttribute CommentToAssign c, HttpServletRequest req, @PathVariable("board_id") Long id){
        service.makecommetns(c,req,id);

        return "ok";
    }


    @GetMapping("/getboardlist")

    public ResponseEntity<ApiResponse<List<BoardsToShow>>> boardlist(){
        List<BoardsToShow> b=service.boardslist();
        ApiResponse api=new ApiResponse(new Status("success",HttpStatus.OK.value()),b);



        return new ResponseEntity<>(api,HttpStatus.OK);

    }

    @GetMapping("/getcommentlist/{board_id}")
    public ResponseEntity<ApiResponse<List<CommentToShow>>> getcommentlist(@PathVariable("board_id") Long id){
            List<CommentToShow> c=service.commentlist(id);

        ApiResponse api=new ApiResponse(new Status("success",HttpStatus.OK.value()),c);
            return new ResponseEntity<>(api,HttpStatus.OK);
    }


}
