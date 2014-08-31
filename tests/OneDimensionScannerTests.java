import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OneDimensionScannerTests {

    @Test (expected = IntegerDomainError.class)
    public void oneDimensionScannerConstructorExceptionCellsNumberTest(){
        OneDimensionScanner oneDimensionScanner = new OneDimensionScanner(0,5);
        RunTimeChecks.suppressUnusedVariableGitWarning(oneDimensionScanner); //this line will never be executed
    }

    @Test (expected = IntegerDomainError.class)
    public void oneDimensionScannerConstructorExceptionPositionLessTest(){
        OneDimensionScanner oneDimensionScanner = new OneDimensionScanner(10,-1);
        RunTimeChecks.suppressUnusedVariableGitWarning(oneDimensionScanner); //this line will never be executed
    }

    @Test (expected = IntegerDomainError.class)
    public void oneDimensionScannerConstructorExceptionPositionMoreTest(){
        OneDimensionScanner oneDimensionScanner = new OneDimensionScanner(10,11);
        RunTimeChecks.suppressUnusedVariableGitWarning(oneDimensionScanner); //this line will never be executed
    }

    @Test
    public void oneDimensionScannerInitialSetTest(){
        OneDimensionScanner oneDimensionScanner = new OneDimensionScanner(10,0);
        assertEquals("Check initial current position",0,oneDimensionScanner.getCurrentPosition().getX());
        assertEquals("Check initial current position",0,oneDimensionScanner.getCurrentPosition().getY());

        OneDimensionScanner oneDimensionScanner1 = new OneDimensionScanner(10,4);
        assertEquals("Check initial current position",4,oneDimensionScanner1.getCurrentPosition().getX());
        assertEquals("Check initial current position",0,oneDimensionScanner1.getCurrentPosition().getY());

        OneDimensionScanner oneDimensionScanner2 = new OneDimensionScanner(10,9);
        assertEquals("Check initial current position",9,oneDimensionScanner2.getCurrentPosition().getX());
        assertEquals("Check initial current position",0,oneDimensionScanner2.getCurrentPosition().getY());
    }

    @Test (expected = IntegerDomainError.class)
    public void oneDimensionScannerSetNewPositionInvalidTooBigTest(){
        OneDimensionScanner oneDimensionScanner = new OneDimensionScanner(10,0);
        Position newPosition = new Position(10,0);
        oneDimensionScanner.setNewPosition(newPosition);
    }

    @Test
    public void oneDimensionScannerSetNewPositionTest(){
        OneDimensionScanner oneDimensionScanner = new OneDimensionScanner(10,0);

        assertEquals("Check initial current position",0,oneDimensionScanner.getCurrentPosition().getX());
        assertEquals("Check initial current position",0,oneDimensionScanner.getCurrentPosition().getY());

        Position newPosition = new Position(4,0);
        oneDimensionScanner.setNewPosition(newPosition);

        assertEquals("Check new set position",4,oneDimensionScanner.getCurrentPosition().getX());
        assertEquals("Check new set position",0,oneDimensionScanner.getCurrentPosition().getY());

        newPosition = new Position(6,0);

        assertEquals("Check new set position",4,oneDimensionScanner.getCurrentPosition().getX());
        assertEquals("Check new set position",0,oneDimensionScanner.getCurrentPosition().getY());

        oneDimensionScanner.setNewPosition(newPosition);

        assertEquals("Check new set position",6,oneDimensionScanner.getCurrentPosition().getX());
        assertEquals("Check new set position",0,oneDimensionScanner.getCurrentPosition().getY());
    }

    @Test
    public void oneDimensionScannerNextTest(){
        OneDimensionScanner oneDimensionScanner = new OneDimensionScanner(5,2);

        assertEquals("Check initial current position",2,oneDimensionScanner.getCurrentPosition().getX());
        assertEquals("Check initial current position",0,oneDimensionScanner.getCurrentPosition().getY());

        Position position = oneDimensionScanner.next();
        assertEquals("Check incremented position",3,position.getX());
        assertEquals("Check incremented position",0,position.getY());

        assertEquals("Check incremented against current",
                position.getX(),
                oneDimensionScanner.getCurrentPosition().getX());
        assertEquals("Check incremented against current",
                position.getY(),
                oneDimensionScanner.getCurrentPosition().getY());

        position = oneDimensionScanner.next();
        assertEquals("Check incremented position",4,position.getX());
        assertEquals("Check incremented position",0,position.getY());

        position = oneDimensionScanner.next();
        assertEquals("Check incremented position",0,position.getX());
        assertEquals("Check incremented position",0,position.getY());

        position = oneDimensionScanner.next();
        assertEquals("Check incremented position",1,position.getX());
        assertEquals("Check incremented position",0,position.getY());

        position = oneDimensionScanner.next();
        assertEquals("Check incremented position",2,position.getX());
        assertEquals("Check incremented position",0,position.getY());

        position = oneDimensionScanner.next();
        assertEquals("Check incremented position",3,position.getX());
        assertEquals("Check incremented position",0,position.getY());
    }

    @Test
    public void oneDimensionScannerResetTest(){
        OneDimensionScanner oneDimensionScanner = new OneDimensionScanner(5,2);

        assertEquals("Check initial current position",2,oneDimensionScanner.getCurrentPosition().getX());
        assertEquals("Check initial current position",0,oneDimensionScanner.getCurrentPosition().getY());

        Position position = oneDimensionScanner.next();
        assertEquals("Check incremented position",3,position.getX());
        assertEquals("Check incremented position",0,position.getY());

        position = oneDimensionScanner.reset();
        assertEquals("Check incremented position",2,position.getX());
        assertEquals("Check incremented position",0,position.getY());
    }

    @Test
    public void oneDimensionScannerToStringTest(){
        OneDimensionScanner oneDimensionScanner = new OneDimensionScanner(5,2);
        String oneDimensionalScannerText =
            "OneDimensionScanner{maxPosition=Position{x=4, y=0}, " +
            "current=Position{x=2, y=0}, startPosition=Position{x=2, y=0}}";

        assertEquals("Check toString method",oneDimensionScanner.toString(),oneDimensionalScannerText);
    }

}
