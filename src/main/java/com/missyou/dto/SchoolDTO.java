package com.missyou.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class SchoolDTO {

    @Length(min=2)
    private String schoolName;
}
