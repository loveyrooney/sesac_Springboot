package sesac.JPA.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class BusinessExceptionHandler {
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<Map<String, String>> handleException(BusinessException e, HttpServletRequest request) {

        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus httpStatus = e.getErrorCode().getHttpStatus();

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", e.getErrorCode().getHttpStatus().toString());
        map.put("message", e.getErrorCode().getMessage());

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }
}
