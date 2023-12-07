package sesac.JPA.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
public class CreateBoardDTO {
    private String userId;
    private String boardTitle;
    private String boardContent;
    private String boardDate;
}
