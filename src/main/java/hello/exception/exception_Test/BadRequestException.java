package hello.exception.exception_Test;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "wrong request")
public class BadRequestException extends RuntimeException {

}
