package chatprogram.chatprogramdemo.entity;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter
public class BoardsToShow {


    private Long id;

    private String title;


    private LocalDateTime localDateTime;


    public BoardsToShow(Long id, String title, LocalDateTime localDateTime) {
        this.id = id;
        this.title = title;
        this.localDateTime = localDateTime;
    }
}
