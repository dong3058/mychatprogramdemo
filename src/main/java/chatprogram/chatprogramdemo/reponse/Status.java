package chatprogram.chatprogramdemo.reponse;

import lombok.Getter;

@Getter
public class Status {

    private String message;

    private int error_code;


    public Status(String message, int error_code) {
        this.message = message;
        this.error_code = error_code;
    }
}
