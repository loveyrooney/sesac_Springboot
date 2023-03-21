package sesac.JPA.domain;

import javax.persistence.*;

@Entity
@Table(name="Reply")
public class ReplyEntity {

    @Id
    @GeneratedValue
    private int id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId", referencedColumnName = "id")
    private UserEntity userEntity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="boardId", referencedColumnName = "boardId")
    private BoardEntity boardEntity;

    @Lob
    private String content;

    @Column(length = 20, nullable = false)
    private String date;
}
