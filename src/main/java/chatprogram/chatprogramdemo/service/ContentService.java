package chatprogram.chatprogramdemo.service;

import chatprogram.chatprogramdemo.entity.*;
import chatprogram.chatprogramdemo.repositroy.ContentRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@Transactional
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository repository;


    public void makeboards(Boards b, HttpServletRequest req){

        repository.addboards(b,req);

    }

    public Boards getboards(Long id){
        return repository.getboards(id);
    }

    public void makecommetns(CommentToAssign c, HttpServletRequest req, Long id){

        repository.addcomment(c,req,id);
    }

    public Comments makecommentsforwebsocket(CommentToAssign c, String userid, Long id){


        return repository.makecoomentsocket(c,userid,id);
    }

    public boolean checkuserinboards(String userid,Long id){
        return repository.checkuserinboard(userid,id);
    }

    public List<BoardsToShow> boardslist(){


        return repository.getboardslist();
    }

    public List<CommentToShow> commentlist(Long id){


        return repository.getcommentlist(id);
    }
}
