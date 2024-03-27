package chatprogram.chatprogramdemo.errors;

import lombok.Data;

@Data
public class ErrorForm extends RuntimeException{

    private Datas data;

    private Status s;

    public ErrorForm(Datas data,Status s){
        super();
        this.data=data;
        this.s=s;
    }



}