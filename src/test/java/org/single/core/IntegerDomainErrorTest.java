package org.single.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class IntegerDomainErrorTest {

    @Test
    public void integerDomainErrorTest() {
        String errorMessage = "Error message";
        IntegerDomainError integerDomainError = new IntegerDomainError(errorMessage, 5, 7);

        assertEquals("Check error message", errorMessage, integerDomainError.getMessage());
        assertEquals("Check runtime value", 5, integerDomainError.getRuntimeValue());
        assertEquals("Check error message", 7, integerDomainError.getConstraint());
    }
}

