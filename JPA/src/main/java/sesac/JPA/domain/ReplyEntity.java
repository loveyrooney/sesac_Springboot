package sesac.JPA.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="ReplyDB")
@Getter
@Setter
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

    @Column(length = 1000, nullable = false)
    private String replyContent;

    @Column(length = 20, nullable = false)
    private String replyDate;
}
