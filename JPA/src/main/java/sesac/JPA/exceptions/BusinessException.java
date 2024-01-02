package sesac.JPA.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public class BusinessException extends RuntimeException {
    private final ErrorCode errorCode;

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<Map<String, String>> BusinessHandleException(BusinessException e, HttpServletRequest request) {

        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus httpStatus = e.getErrorCode().getHttpStatus();

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", e.getErrorCode().getHttpStatus().toString());
        map.put("message", e.getErrorCode().getMessage());

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }
}
