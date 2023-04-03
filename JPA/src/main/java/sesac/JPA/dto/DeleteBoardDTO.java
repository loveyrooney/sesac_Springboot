package sesac.JPA.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteBoardDTO {
    private int boardId;
    private String userId;
    private String boardTitle;
    private String boardContent;
    private String boardDate;
    private String pw;
}
