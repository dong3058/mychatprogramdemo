package chatprogram.chatprogramdemo.repositroy;

import chatprogram.chatprogramdemo.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
@RequiredArgsConstructor
@Slf4j
public class ContentRepository {

    private final EntityManager em;

    public void addboards(Boards b, HttpServletRequest req){
        Member member=em.find(Member.class, (String) req.getSession(false).getAttribute("id"));
        MemberandBoard memberandBoard=new MemberandBoard(member,b);
        memberandBoard.setMember_join_time(LocalDateTime.now());
        em.persist(b);
        em.persist(memberandBoard);
    }





    public void addcomment(CommentToAssign c,HttpServletRequest req,Long id){

        Comments comment=new Comments();
        comment.setMaintext(c.getMaintext());
        String user_id=getidfromsession(req);
        Boards boards=em.find(Boards.class,id);
        Member member=em.find(Member.class,user_id);
        comment.setBoards(boards);
        comment.setMember(member);
        comment.setDate(LocalDateTime.now());
        em.persist(comment);

    }



    public Comments makecoomentsocket (CommentToAssign c,String user_id,Long id){

        Comments comment=new Comments();
        comment.setMaintext(c.getMaintext());
        Boards boards=em.find(Boards.class,id);
        Member member=em.find(Member.class,user_id);
        comment.setBoards(boards);
        comment.setMember(member);
        comment.setDate(LocalDateTime.now());
        em.persist(comment);
        return comment;
    }


    public Boards getboards(Long id){
        return em.find(Boards.class,id);
    }




    public List<BoardsToShow> getboardslist(){

        List<MemberandBoard> b=em.createQuery("select b from MemberandBoard b join fetch b,boards")
                .getResultList();

        return b.stream()
                .map(x->new BoardsToShow(x.getBoards().getId(),x.getBoards().getTitle(),x.getMember_join_time()))
                .collect(Collectors.toList());



    }

    public Boolean checkuserinboard(String userid,Long id){
        List<MemberandBoard> m=em.createQuery("select b from MemberandBoard b where b.boards_id=:id and b.member_id=:userid")
                .getResultList();
        log.info("m is empty?:{} {}",m,m.isEmpty());
        if (m.isEmpty()){
            return true;
        }
        return false;

    }


    public String getidfromsession(HttpServletRequest req){
        return (String) req.getSession(false).getAttribute("id");
    }


    public List<CommentToShow> getcommentlist(Long id){
        List<MemberandBoard> b=em.createQuery("select b from MemberandBoard b join fetch b.boards bs,join fetch bs.comments,join fetch b.member where b.id=:id")
                .setParameter("id",id)
                .getResultList();

        MemberandBoard m=b.get(0);
        Member member=m.getMember();
        return m.getBoards().getComments().stream()
                .map(x->new CommentToShow(x.getId(),x.getMember().getEmail(),x.getMaintext(),x.getDate()))
                .collect(Collectors.toList());



    }

}
