package hello.exception.api;

import hello.exception.exception_Test.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
public class ApiExceptionController {

    @GetMapping("/api/members/{id}")
    public MemberDto getMember(@PathVariable("id") String id){

        log.info("getMember");
        if (id.equals("ex")) {
            throw new RuntimeException("wrong users");
        }
        else if (id.equals("Http")) {
            throw new HttpMessageNotReadableException("wrong users");
        }
        log.info("getMember");
        return new MemberDto(id, "hello" + id);

    }

    @GetMapping("/api.response-status-ex1")
    public String responseStatusEx1(){
        throw new BadRequestException();
    }

    @GetMapping("/api.response-status-ex2")
    public String responseStatusEx2(){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error bad", new IllegalArgumentException());
    }

    @Data
    @AllArgsConstructor
    static class MemberDto {
        private String memberId;
        private String name;
    }
}
