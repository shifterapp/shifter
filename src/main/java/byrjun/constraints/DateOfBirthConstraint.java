package byrjun.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import javax.validation.Constraint;
import javax.validation.Payload;

import byrjun.validators.DateOfBirthValidator;

@Documented
@Constraint(validatedBy = DateOfBirthValidator.class)
@Target( { METHOD, FIELD })
@Retention(RUNTIME)
public @interface DateOfBirthConstraint {
    String message() default "Dagsetning er á röngu formi";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
