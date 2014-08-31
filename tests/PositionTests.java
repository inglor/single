import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class PositionTests {

    @Test (expected = IntegerDomainError.class)
    public void positionConstructorExceptionXTest(){
        Position position = new Position(-3,5);
        RunTimeChecks.suppressUnusedVariableGitWarning(position); //this line will never be executed
    }

    @Test (expected = IntegerDomainError.class)
    public void positionConstructorExceptionYTest(){
        Position position = new Position(5,-2);
        RunTimeChecks.suppressUnusedVariableGitWarning(position); //this line will never be executed
    }

    @Test
    public void positionGetterTest(){
        Position position = new Position(4,5);
        assertEquals("Check x getter",4,position.getX());
        assertEquals("Check y getter",5,position.getY());
    }

    @Test
    public void positionZeroTest(){
        Position position = new Position(0,0);
        assertEquals("Check x getter",0,position.getX());
        assertEquals("Check y getter",0,position.getY());
    }

    @Test
    public void positionToStringTest(){
        Position position = new Position(4,5);
        assertEquals("Check toString method","Position{x=4, y=5}",position.toString());
    }
}
