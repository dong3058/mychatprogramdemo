package chatprogram.chatprogramdemo.repositroy;


import chatprogram.chatprogramdemo.entity.LoginForm;
import chatprogram.chatprogramdemo.entity.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LoginRepository {


    private final EntityManager em;

    public Optional<Member> logincheck(LoginForm l){
        Member m=em.find(Member.class,l.getId());
        if(l.getPassword().equals(m.getPassword())){


            return Optional.ofNullable(null);
        }
        return Optional.ofNullable(m);
    }

}
