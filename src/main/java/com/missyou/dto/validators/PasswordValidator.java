package com.missyou.dto.validators;

import com.missyou.dto.PersonDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordEqual, PersonDTO> {
    @Override
    public void initialize(PasswordEqual constraintAnnotation) {
        int min = constraintAnnotation.min();
        int max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(PersonDTO personDTO, ConstraintValidatorContext constraintValidatorContext) {
        String password1 = personDTO.getPassword1();
        String password2 = personDTO.getPassword2();

        return password1.equals(password2);
    }
}
