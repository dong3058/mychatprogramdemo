package chatprogram.chatprogramdemo.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class MemberandBoard {


    @Id
    @GeneratedValue
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="boards_id")
    private Boards boards;

    @Column
    private LocalDateTime member_join_time;


    public MemberandBoard() {
    }

    public MemberandBoard(Member member, Boards boards) {
        this.member = member;
        this.boards = boards;
    }
}
