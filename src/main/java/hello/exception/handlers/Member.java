package hello.exception.handlers;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

public class Member {

    @NotBlank
    private String name;

    @NotNull
    @Range(min = 1000, max = 1000000)
    private int age;
}
