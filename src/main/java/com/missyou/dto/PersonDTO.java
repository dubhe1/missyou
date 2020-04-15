package com.missyou.dto;

import com.missyou.dto.validators.PasswordEqual;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Builder
@Getter
@PasswordEqual(message = "两次密码不相同")
public class PersonDTO {
    @Length(min = 2, max = 10, message = "xxxxx")
    private final String name;
    private final Integer age;

    private final String password1;
    private final String password2;
}



