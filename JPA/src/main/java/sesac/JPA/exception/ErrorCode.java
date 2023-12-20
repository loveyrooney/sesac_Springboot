package sesac.JPA.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    INVALID_ACCESS(HttpStatus.UNAUTHORIZED,"로그인 후 이용할 수 있습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
