package hello.exception.handlers;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpMessageTester {

    @PostMapping("test")
    public String test(@RequestBody @Valid Member member, BindingResult bindingResult) {

        return "Success";
    }

}
