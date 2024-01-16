package sesac.JPA.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> ValidHandleException(MethodArgumentNotValidException e, HttpServletRequest request) {

        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", e.getBindingResult().getAllErrors().get(0).getDefaultMessage());

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<Map<String, String>> BusinessHandleException(BusinessException e, HttpServletRequest request) {

        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus httpStatus = e.getErrorCode().getHttpStatus();

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", e.getErrorCode().getHttpStatus().toString());
        map.put("message", e.getErrorCode().getMessage());
        System.out.println(e.getErrorCode().getMessage());
        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }
}
