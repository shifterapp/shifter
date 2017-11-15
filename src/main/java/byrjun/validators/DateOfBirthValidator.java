package byrjun.validators;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import byrjun.constraints.DateOfBirthConstraint;

public class DateOfBirthValidator implements
ConstraintValidator<DateOfBirthConstraint, LocalDate> {

  @Override
  public void initialize(DateOfBirthConstraint localDate) {
  }

@Override
public boolean isValid(LocalDate contactField, ConstraintValidatorContext cxt) {
	return contactField != null&&contactField.isBefore(LocalDate.now());
}

}
