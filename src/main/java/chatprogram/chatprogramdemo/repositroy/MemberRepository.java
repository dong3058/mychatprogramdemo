package chatprogram.chatprogramdemo.repositroy;


import chatprogram.chatprogramdemo.entity.Member;
import chatprogram.chatprogramdemo.entity.MemberForAssign;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDateTime;


@RequiredArgsConstructor
@Repository
@Slf4j
public class MemberRepository {


    private final EntityManager em;

    public void save(MemberForAssign m){
        log.info("m in repository:{}{}{}",m.getEmail(),m.getUsername(),m.getPassword());
        Member member=new Member(m.getEmail(),m.getUsername(),m.getPassword());
        member.setAssign_date(LocalDateTime.now());
        em.persist(member);

    }


    public Member findmember(String id){
       return  em.find(Member.class,id);
    }




}
