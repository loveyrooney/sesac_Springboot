package sesac.JPA.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    INVALID_ACCESS(HttpStatus.UNAUTHORIZED,"로그인 후 이용할 수 있습니다."),
    UNABLE_TO_SEND_MAIL(HttpStatus.INTERNAL_SERVER_ERROR, "이메일 요청에 실패하였습니다."),
    NOT_EXIST_AUTHCODE(HttpStatus.NOT_FOUND,"이메일 인증 코드를 확인할 수 없습니다."),
    NOT_EXIST_BOARD(HttpStatus.NOT_FOUND, "해당 글을 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
