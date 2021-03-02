package com.marcin.credit_application.domain.Validation;

import com.marcin.credit_application.domain.Credit.Credit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Component
public class InputValidation {

    private static final Logger LOGGER = LoggerFactory.getLogger(Credit.class);

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    public boolean validate(Object object) {
        Set<ConstraintViolation<Object>> violations = validator.validate(object);

        for (ConstraintViolation<Object> violation : violations) {
            LOGGER.error(violation.getMessage());
        }

        if (violations.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

}
