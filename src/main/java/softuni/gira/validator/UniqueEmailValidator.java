package softuni.gira.validator;

import softuni.gira.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

private final UserService userService;

   public UniqueEmailValidator(UserService userService) {
      this.userService = userService;
   }

   public boolean isValid(String email, ConstraintValidatorContext context) {

      return this.userService.isEmailUnique(email);
   }
}
