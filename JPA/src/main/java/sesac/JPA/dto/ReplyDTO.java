package sesac.JPA.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ReplyDTO {
    @Id
    @GeneratedValue
    private int replyId;
    private String userId;
    private String boardId;
    private String content;
    private String date;

}
