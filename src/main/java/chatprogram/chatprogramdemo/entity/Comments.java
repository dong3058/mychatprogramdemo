package chatprogram.chatprogramdemo.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
public class Comments {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String maintext;

    @Column(name="create_date")
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_id")
    private Boards boards;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;


    public Comments() {
    }


    public void makeCommentsObject(LocalDateTime localDateTime,Member m,Boards b){

        this.date=localDateTime;
        this.member=m;
        this.boards=b;

    }
}
