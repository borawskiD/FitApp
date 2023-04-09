package pl.borawski.fitapp.config;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Service;
import pl.borawski.fitapp.user.UserService;
import pl.borawski.fitapp.user.UserVerifyDTO;

import java.util.Optional;

@Service
class UniqueFilter implements ConstraintValidator<Unique, String> {
        UserService userService;

    public UniqueFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
        public void initialize(Unique constraintAnnotation) {
            ConstraintValidator.super.initialize(constraintAnnotation);
        }

        @Override
        public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
            Optional<UserVerifyDTO> userByMail = userService.findUserByMail(s);
            return userByMail.isEmpty();
        }
}

