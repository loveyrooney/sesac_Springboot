package sesac.JPA.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BusinessException extends RuntimeException {
    private final ErrorCode errorCode;
}
