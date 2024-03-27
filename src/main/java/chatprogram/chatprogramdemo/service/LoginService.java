package chatprogram.chatprogramdemo.service;


import chatprogram.chatprogramdemo.entity.LoginForm;
import chatprogram.chatprogramdemo.entity.Member;
import chatprogram.chatprogramdemo.repositroy.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional

@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;



    public Optional<Member> logincheck(LoginForm l){

        return loginRepository.logincheck(l);
    }
}
