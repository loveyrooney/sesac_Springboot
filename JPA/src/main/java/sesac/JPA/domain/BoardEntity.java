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
    private int id;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 10, nullable = false)
    private String pw;

    @Column(length = 500, nullable = false)
    private String content;

}
