package chatprogram.chatprogramdemo.entity;

import lombok.Data;

@Data
public class Content {

    private String maintext;

    public Content() {
    }

    public Content(String maintext) {
        this.maintext = maintext;
    }
}
