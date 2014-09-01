public interface Scanner {

    public Position next();

    public Position reset();

    public void setNewPosition(Position position);

    public Position getCurrentPosition();

    public Position switchScanningAxis();
}
