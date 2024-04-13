package com.careersforyou.jobservice.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;



class jobValidationTests {
    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void whenAllFieldsCorrectThenValidationSucceeds() {
        var job =
                new Job("1", "Jr Java Dev", "Peon", "Snobby offices inc", "Java", "Jr");
        Set<ConstraintViolation<Job>> violations = validator.validate(job);
        assertThat(violations).isEmpty();
    }

    @Test
    void whenJobIDDefinedButIncorrectThenValidationFails() {
        var job =
                new Job("Y", "Sr Java Dev", "old dude", "Snobby offices inc", "java", "complaining");
        Set<ConstraintViolation<Job>> violations = validator.validate(job);
        //assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage()).contains("The jobid format must be valid.");
    }
}