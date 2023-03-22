package sesac.JPA.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="board")
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
    private String title;

    @Lob
    private String content;

    @Column(length = 20, nullable = false)
    private String date;

}
