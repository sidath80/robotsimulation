package com.robotsimulation.validation;

public interface ValidationRule {
    void validate(String inputString) throws RuntimeException;
}
