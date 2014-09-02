package org.single.core;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class RunTimeChecksTest {

    private static final String message = "The object is null";
    private static final String invalidRuntimeValue = "Invalid runtime value";

    @Test(expected = NullPointerException.class)
    public void checkNotNullThrowingExceptionTest() {
        RunTimeChecks.checkNotNull(null, message);
    }

    @Test
    public void checkNotNullPositiveResultTest() {
        RunTimeChecks.checkNotNull("Any string", message);
    }

    @Test
    public void checkNotNullExceptionMessage() {
        try {
            RunTimeChecks.checkNotNull(null, message);
        } catch (Exception ex) {
            String exMessage = ex.getMessage();
            /* The following tests will be break if any, even not harmful
             * modification will be perform on RuntimeCheckTests file, this is not
             * ideal, however it is the only truly way to test the error message generated.
             * The alternative is to skip the tests, but this is even more less
             * desirable outcome.
             */
            //Assert that class name is in the error message
            assertTrue(exMessage.contains("RunTimeChecksTest"));
            //Assert that the function name is in the error message
            assertTrue(exMessage.contains("checkNotNullExceptionMessage"));
            //Assert that the file name is in the error message
            assertTrue(exMessage.contains("RunTimeChecksTest.java"));
            //Assert that the line number is in the error message
            assertTrue(exMessage.contains("26"));
        }
    }

    @Test(expected = IntegerDomainError.class)
    public void checkGreaterThanTestLessCase() {
        RunTimeChecks.checkGreaterThan(5, 6, invalidRuntimeValue);
    }

    @Test(expected = IntegerDomainError.class)
    public void checkGreaterThanTestEqualCase() {
        RunTimeChecks.checkGreaterThan(5, 5, invalidRuntimeValue);
    }

    @Test
    public void checkGreaterThanTestGreaterCase() {
        RunTimeChecks.checkGreaterThan(6, 5, invalidRuntimeValue);
    }

    @Test(expected = IntegerDomainError.class)
    public void checkWithinIntervalInclusiveLessThanMin() {
        RunTimeChecks.checkWithinIntervalInclusive(5, 7, 10, invalidRuntimeValue);
    }

    @Test(expected = IntegerDomainError.class)
    public void checkWithinIntervalInclusiveGreaterThanMax() {
        RunTimeChecks.checkWithinIntervalInclusive(11, 7, 10, invalidRuntimeValue);
    }

    @Test
    public void checkWithinIntervalInclusiveWithin() {
        RunTimeChecks.checkWithinIntervalInclusive(7, 7, 10, invalidRuntimeValue);
        RunTimeChecks.checkWithinIntervalInclusive(9, 7, 10, invalidRuntimeValue);
        RunTimeChecks.checkWithinIntervalInclusive(10, 7, 10, invalidRuntimeValue);
    }
}
