package chatprogram.chatprogramdemo.entity;


import lombok.Data;

@Data
public class CommentToAssign {


    private String maintext;

    public CommentToAssign() {
    }

    public CommentToAssign(String maintext) {
        this.maintext = maintext;
    }
}
