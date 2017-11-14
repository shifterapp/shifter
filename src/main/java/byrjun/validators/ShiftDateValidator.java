package byrjun.validators;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import byrjun.constraints.ShiftDateConstraint;

public class ShiftDateValidator implements
ConstraintValidator<ShiftDateConstraint, LocalDate> {

  @Override
  public void initialize(ShiftDateConstraint localDate) {
  }

@Override
public boolean isValid(LocalDate contactField, ConstraintValidatorContext cxt) {
	return contactField != null&&contactField.isAfter(LocalDate.now());
}

}
