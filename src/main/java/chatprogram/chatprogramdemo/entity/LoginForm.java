package chatprogram.chatprogramdemo.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
public class LoginForm {

    @Email
    @NotEmpty
    private String id;

    @NotEmpty
    private String password;
}
