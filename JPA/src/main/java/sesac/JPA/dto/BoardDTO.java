package sesac.JPA.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
public class BoardDTO {

    private int boardId;
    private String userId;
    private String boardTitle;
    private String boardContent;
    private String boardDate;
}
