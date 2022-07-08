package com.example.realestate.phoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Pattern(regexp = "\\d{3}\\d{3}\\d{4}")
@ReportAsSingleViolation
@Constraint(validatedBy = { })
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
public @interface ValidPhoneNumber {
    String message() default "phone number should be in format 9999999999";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}
