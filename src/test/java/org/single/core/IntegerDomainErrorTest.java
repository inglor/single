package org.single.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class IntegerDomainErrorTest {

    @Test
    public void integerDomainErrorTest() {
        String errorMessage = "Error message";
        IntegerDomainError integerDomainError = new IntegerDomainError(errorMessage, 5, 7);

        assertEquals("Check error message", integerDomainError.getMessage(), errorMessage);
        assertEquals("Check runtime value", integerDomainError.getRuntimeValue(), 5);
        assertEquals("Check error message", integerDomainError.getConstraint(), 7);
    }
}

