package sesac.JPA.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="board")
@Getter
@Setter
public class BoardEntity {

    @OneToOne(mappedBy = "Board")
    private ReplyEntity replyEntity;
    @Id
    @GeneratedValue
    private int boardId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId",referencedColumnName = "id")

    @Column(length = 30, nullable = false)
    private String title;

    @Lob
    private String content;

    @Column(length = 20, nullable = false)
    private String date;

}
