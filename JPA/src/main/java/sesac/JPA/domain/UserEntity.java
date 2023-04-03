package sesac.JPA.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="UserDB")
@Getter
@Setter
public class UserEntity {

    @Id
    @Column(length = 20, nullable = false , name="userId")
    private String id;

    @Column(length = 20, nullable = false)
    private String pw;

}


