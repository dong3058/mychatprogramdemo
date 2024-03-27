package chatprogram.chatprogramdemo.errors;

import lombok.Data;

@Data
public class Datas <T>{
    private T data;

    public Datas(T data) {
        this.data = data;
    }
}
