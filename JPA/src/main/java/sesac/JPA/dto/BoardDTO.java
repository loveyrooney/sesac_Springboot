package sesac.JPA.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;

@Getter
@Setter
public class BoardDTO {

    private int id;
    private String name;
    private String pw;
    private String content;
}
