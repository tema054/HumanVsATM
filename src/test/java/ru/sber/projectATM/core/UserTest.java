package ru.sber.projectATM.core;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private static Validator validator;

   /* @BeforeAll
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

    }

    @Test
    void setPan() {
        User user = new User("1111222233334444", -1);
        Set<ConstraintViolation<User>> constraintViolations =
                validator.validate(user);
        assertEquals("должно быть не меньше 0", constraintViolations.iterator().next().getMessage());
        User user2 = new User("1111222233334444", 10000);
        constraintViolations = validator.validate(user2);
        assertEquals("должно быть не больше 9999", constraintViolations.iterator().next().getExecutableReturnValue());
    }*/

    @Test
    void setPin() {

        //assertEquals( "должно быть не меньше 0", constraintViolations.iterator().next().);
        //как проверить не понятно
    }
}