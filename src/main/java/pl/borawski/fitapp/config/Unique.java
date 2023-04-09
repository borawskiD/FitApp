package pl.borawski.fitapp.config;

import jakarta.validation.Constraint;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = UniqueFilter.class)
@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
public @interface Unique {
    String message() default "This field is taken!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}