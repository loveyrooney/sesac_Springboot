package sesac.JPA.domain;

import javax.persistence.*;

@Entity
@Table(name="ReplyDB")
public class ReplyEntity {

    @Id
    @GeneratedValue
    private int replyId;
    @ManyToOne
    @JoinColumn(name="userId")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name="boardId")
    private BoardEntity boardEntity;

    @Lob
    private String content;

    @Column(length = 20, nullable = false)
    private String date;
}
