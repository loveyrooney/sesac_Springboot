package sesac.JPA.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="User")
@Getter
@Setter
public class UserEntity {

    @Id
    @Column(length = 20, nullable = false , name="userId")
    private String id;

    @Column(length = 20, nullable = false)
    private String pw;

}


