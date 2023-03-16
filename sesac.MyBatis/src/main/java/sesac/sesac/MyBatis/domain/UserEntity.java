package sesac.sesac.MyBatis.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="user")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue
    private int id; // auto_increment

    @Column(length = 20,nullable = false)
    private String name;

    @Column(length = 20,nullable = false)
    private String nickname;


}
