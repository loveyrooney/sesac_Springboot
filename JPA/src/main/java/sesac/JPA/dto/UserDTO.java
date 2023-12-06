package sesac.JPA.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class UserDTO {

    @Id
    private String id;

    @Pattern(regexp="^[a-zA-Z]\\w{5,14}$", message="비밀번호는 영문 대소문자와 특수기호를 포함하여 5-14자리 내에 있어야 합니다")
    private String pw;

}
