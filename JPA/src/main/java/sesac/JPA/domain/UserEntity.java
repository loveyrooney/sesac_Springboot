package sesac.JPA.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="User")
@Getter
@Setter
public class UserEntity {
    @OneToOne(mappedBy = "User")
    private ReplyEntity replyEntity;
    @OneToOne(mappedBy = "User")
    private BoardEntity boardEntity;

    @Id
    @Column(length = 20, nullable = false)
    private String id;

    @Column(length = 20, nullable = false)
    private String pw;

}


