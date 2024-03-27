package chatprogram.chatprogramdemo.entity;


import lombok.Data;

@Data
public class MessageTest {

    private String username;
    private String chatroomid;

    public MessageTest() {
    }

    public MessageTest(String username, String chatroomid) {
        this.username = username;
        this.chatroomid = chatroomid;
    }
}
