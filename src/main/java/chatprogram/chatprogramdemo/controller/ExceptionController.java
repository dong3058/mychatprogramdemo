package chatprogram.chatprogramdemo.controller;


import chatprogram.chatprogramdemo.entity.Content;
import chatprogram.chatprogramdemo.errors.ErrorForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionController {


    @ExceptionHandler(ErrorForm.class)
    public ResponseEntity<ErrorForm> exceptioncompletet(ErrorForm e){

        log.info("Errormesge:{}",e.getMessage());
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(RuntimeException.class)
    public Content exceptioncompletet2(RuntimeException e){

        log.info("Errormesge:{}",e.getMessage());
        return new Content("error");
    }

}
