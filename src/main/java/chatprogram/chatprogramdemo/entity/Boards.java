package chatprogram.chatprogramdemo.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.List;



@Data
@Entity
public class Boards {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;


    @BatchSize(size=2)
    @OneToMany(fetch = FetchType.LAZY,mappedBy="boards")
    private List<Comments> comments=new ArrayList<>();


}
