package org.single.core;


final public class RunTimeChecks {

    private RunTimeChecks(){
    }

    public static void suppressUnusedVariableGitWarning(Object obj) {
        checkNotNull(obj, "");
    }

    private static String hereAt(int levelUpInTheStack) {
        StackTraceElement ste = Thread.currentThread().getStackTrace()[levelUpInTheStack];
        return ste.toString();
    }

    public static void checkNotNull(Object toCheck, String message) {
        final int levelUpInTheStack = 3;
        if (toCheck == null) {
            throw new IllegalArgumentException(hereAt(levelUpInTheStack) + " error: " + message);
        }
    }

    public static void checkGreaterThan(int runtimeValue, int constraint, String message) {
        if (runtimeValue <= constraint) {
            throw new IntegerDomainError(
                    message.concat(": the runtime value ").concat(String.valueOf(runtimeValue)).
                            concat(" has to be greater than constraint ").concat(String.valueOf(constraint)),
                    runtimeValue,
                    constraint);
        }
    }

    public static void checkWithinIntervalInclusive(int runtimeValue, int minValue, int maxValue, String message) {
        if (minValue > maxValue) {
            throw new IntegerDomainError(
                    "Invalid inclusive interval, min value greater than max value", minValue, maxValue);
        }
        if (runtimeValue < minValue) {
            throw new IntegerDomainError(
                    message.concat("Invalid run time value ").concat(String.valueOf(runtimeValue))
                            .concat(" is less then ").concat(String.valueOf(minValue)),
                    runtimeValue,
                    minValue);
        }
        if (runtimeValue > maxValue) {
            throw new IntegerDomainError(
                    message.concat("Invalid run time value ").concat(String.valueOf(runtimeValue))
                            .concat(" is greater then ").concat(String.valueOf(maxValue)),
                    runtimeValue,
                    maxValue);

        }
    }
}
