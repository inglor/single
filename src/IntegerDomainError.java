public class IntegerDomainError extends RuntimeException {

    private final int runtimeValue;
    private final int constraint;

    public IntegerDomainError(String message,int runtimeValue, int constraint){
        super(message);
        this.runtimeValue = runtimeValue;
        this.constraint = constraint;
    }

    public int getRuntimeValue() {
        return runtimeValue;
    }

    public int getConstraint() {
        return constraint;
    }
}
