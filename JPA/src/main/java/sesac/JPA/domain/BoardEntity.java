package sesac.JPA.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="boardDB")
@Getter
@Setter
public class BoardEntity {
    @Id
    @GeneratedValue
    private int boardId;

    @ManyToOne
    @JoinColumn(name="userId")
    private UserEntity userEntity;

    @Column(length = 30, nullable = false)
    private String boardTitle;

    @Lob
    private String boardContent;

    @Column(length = 20, nullable = false)
    private String boardDate;

    @OneToMany(mappedBy = "boardEntity", cascade = CascadeType.ALL)
    List<ReplyEntity> replyEntityList = new ArrayList<>();

}
