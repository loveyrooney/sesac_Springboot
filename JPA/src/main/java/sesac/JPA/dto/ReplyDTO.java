package sesac.JPA.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Getter
@Setter
public class ReplyDTO {
    @Id
    private int replyId;
    private String userId;
    private int boardId;
    private String replyContent;
    private String replyDate;

}
