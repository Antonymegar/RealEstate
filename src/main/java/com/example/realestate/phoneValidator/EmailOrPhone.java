package com.example.realestate.phoneValidator;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.lang.annotation.*;

@ConstraintComposition(CompositionType.OR)
@Email
@Pattern(regexp = "^0\\d{11}")
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@ReportAsSingleViolation
@Documented
public @interface EmailOrPhone {

    String message() default "Provided value was neither a valid Email nor a valid Phone number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {  };
}
