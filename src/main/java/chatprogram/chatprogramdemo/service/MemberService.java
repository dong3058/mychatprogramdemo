package chatprogram.chatprogramdemo.service;

import chatprogram.chatprogramdemo.entity.Member;
import chatprogram.chatprogramdemo.entity.MemberForAssign;
import chatprogram.chatprogramdemo.repositroy.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void save(MemberForAssign m){

        memberRepository.save(m);
    }


    public Member findmember(String id){
        return memberRepository.findmember(id);
    }
}
