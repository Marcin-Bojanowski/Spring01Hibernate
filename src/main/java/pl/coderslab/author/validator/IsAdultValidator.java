package pl.coderslab.author.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class IsAdultValidator implements ConstraintValidator<IsAdult, Integer> {
    @Override
    public void initialize(IsAdult constraint) {
    }

    @Override
    public boolean isValid(Integer val, ConstraintValidatorContext context) {
        return LocalDateTime.now().getYear() - val >= 18;
    }
}
