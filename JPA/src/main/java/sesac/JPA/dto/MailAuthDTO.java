package sesac.JPA.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class MailAuthDTO {

    private String to;
    private String authCode;
}
