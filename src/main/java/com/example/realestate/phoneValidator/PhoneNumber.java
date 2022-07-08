package com.example.realestate.phoneValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneNumber implements
        ConstraintValidator<PhoneNumberValidationAnnotationName, String> {
    //Here you define your phone number valid pattern
//you can put country code, number length, any specific pattern
    private final String PATTERN = "(country-code)[0-9]{8}" ;

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {

        if(Pattern.matches(PATTERN , phone)) {
            return true ;
        }

        return false ;

    }
}