package sesac.JPA.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
@Getter
@Setter
public class UserDTO {

    @Id
    private String id;
    private String pw;
}
