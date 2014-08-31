public class Position {

    private int x;
    private int y;
    private final static int MINIMUM_VALUE = -1;

    public Position(int x, int y){
        RunTimeChecks.checkGreaterThan(x,MINIMUM_VALUE,"Negative value are not allowed for x axis");
        RunTimeChecks.checkGreaterThan(y,MINIMUM_VALUE,"Negative value are not allowed for y axis");
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
