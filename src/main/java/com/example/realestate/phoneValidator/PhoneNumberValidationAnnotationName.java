package com.example.realestate.phoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD , ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface PhoneNumberValidationAnnotationName {
    String message() default "Message to returned on validation failure";

    Class<?>[] groups() default {} ;

    Class<? extends Payload>[] payload() default {} ;
}
