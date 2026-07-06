package com.zubova.module1.exception.practice.codeReview;

import java.util.List;
import java.util.logging.Logger;

public class UserValidator {

    private static final Logger LOGGER = Logger.getLogger(UserValidator.class.getName());
    private static final List<String> BLOCKED_EMAILS = List.of("spam@example.com");

    public void registerUser(User user) {
        try {
            validateUser(user);
        } catch (EmailValidationException e) {
            LOGGER.severe("Validation error");
        }
    }

    public void validateUser(User user) throws EmailValidationException {
        validateEmail(user);
    }

    private void validateEmail(User user) throws EmailValidationException {
        if (user.getEmail() == null) {
            throw new EmailValidationException("Email не может быть null");
        }
        if (BLOCKED_EMAILS.contains(user.getEmail())) {
            throw new EmailValidationException("Email содержит невалидную почту");
        }
    }

}