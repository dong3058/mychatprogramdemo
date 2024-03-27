package chatprogram.chatprogramdemo.reponse;

import lombok.Getter;

@Getter
public class ApiResponse<T> {
    private Status status;

    private  T Data;

    public ApiResponse(Status status, T data) {
        this.status = status;
        Data = data;
    }
}
