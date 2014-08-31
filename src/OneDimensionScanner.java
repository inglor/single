public class OneDimensionScanner implements Scanner {

    private static final int VALUE_Y = 0;
    private Position maxPosition;
    private Position current;
    private Position startPosition;

    public OneDimensionScanner(int numberOfCells,int initialPosition){
        RunTimeChecks.checkGreaterThan(numberOfCells, 0, "Error with the number of cells");
        RunTimeChecks.checkWithinIntervalInclusive(
                initialPosition,
                0,
                numberOfCells,
                "Error with the initial position");
        this.maxPosition = new Position(numberOfCells-1,VALUE_Y);
        this.current = new Position(initialPosition,VALUE_Y);
        this.startPosition = new Position(initialPosition,VALUE_Y);
    }

    @Override
    public Position next() {
        int nextX = current.getX()+1;
        if (nextX > maxPosition.getX())
            nextX = 0;
        current = new Position(nextX,current.getY());
        return new Position(nextX,current.getY());
    }

    @Override
    public Position reset() {
        current = new Position(startPosition.getX(),startPosition.getY());
        return new Position(startPosition.getX(),startPosition.getY());
    }

    @Override
    public void setNewPosition(Position position) {
        RunTimeChecks.checkNotNull(position,"The position object is null");
        RunTimeChecks.checkWithinIntervalInclusive(
                position.getX(),
                0,
                maxPosition.getX(),
                "Error with the initial position");
        current = new Position(position.getX(),position.getY());
    }

    @Override
    public Position getCurrentPosition() {
        return new Position(current.getX(),current.getY());
    }

    @Override
    public String toString() {
        return "OneDimensionScanner{" +
                "maxPosition=" + maxPosition +
                ", current=" + current +
                ", startPosition=" + startPosition +
                '}';
    }
}
