package sesac.JPA.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailAuthDTO {
    private String to;
    private String subject;
    private String authCode;
}
