package chatprogram.chatprogramdemo.errors;


import lombok.Data;

@Data
public class Status {

    private String errormessage;

    private int errorcode;


    public Status(String errormessage, int errorcode) {
        this.errormessage = errormessage;
        this.errorcode = errorcode;
    }
}
