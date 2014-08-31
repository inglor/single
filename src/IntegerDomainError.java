public class IntegerDomainError extends RuntimeException {

    private int runtimeValue;
    private int constraint;

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
