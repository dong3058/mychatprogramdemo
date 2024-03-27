package chatprogram.chatprogramdemo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import org.hibernate.annotations.Cascade;

import java.time.LocalDateTime;

@Getter
@Entity
public class Member {



    @Id
    @Email
    @NotEmpty
    private String email;


    @NotEmpty
    @Column(unique = true)
    private String username;


    @NotEmpty
    private String password;


    @Column(name="assign_date")
    private LocalDateTime assign_date;

    public void setAssign_date(LocalDateTime assign_date) {
        this.assign_date = assign_date;
    }

    public Member() {

    }

    public Member(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
