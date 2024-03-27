package chatprogram.chatprogramdemo.entity;

import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class CommentToShow {

    private Long comment_id;

    private String user_id;
    private String maintext;

    private LocalDateTime comment_date;


    public CommentToShow(Long comment_id, String user_id, String maintext, LocalDateTime comment_date) {
        this.comment_id = comment_id;
        this.user_id = user_id;
        this.maintext = maintext;
        this.comment_date = comment_date;
    }
}
