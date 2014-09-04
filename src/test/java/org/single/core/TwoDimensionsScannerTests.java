package org.single.core;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TwoDimensionsScannerTests {

    @Test (expected = IntegerDomainError.class)
    public void constructorExceptionXTest(){
        Scanner scanner = new TwoDimensionsScanner(new Position(10,0),new Position(5,4));
        RunTimeChecks.suppressUnusedVariableGitWarning(scanner);
    }

    @Test (expected = IntegerDomainError.class)
    public void constructorExceptionYTest(){
        Scanner scanner = new TwoDimensionsScanner(new Position(3,5),new Position(5,4));
        RunTimeChecks.suppressUnusedVariableGitWarning(scanner);
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructorExceptionNullInitialPositionTest(){
        Scanner scanner = new TwoDimensionsScanner(null,new Position(5,4));
        RunTimeChecks.suppressUnusedVariableGitWarning(scanner);
    }

    @Test (expected = NullPointerException.class)
    public void constructorExceptionNullMaxPositionTest(){
        Scanner scanner = new TwoDimensionsScanner(new Position(5,4),null);
        RunTimeChecks.suppressUnusedVariableGitWarning(scanner);
    }

    @Test
    public void setNewPositionTest(){
        Scanner scanner = new TwoDimensionsScanner(new Position(1,2),new Position(5,4));

        assertEquals("Check initial Position",1,scanner.getCurrentPosition().getX());
        assertEquals("Check initial Position",2,scanner.getCurrentPosition().getY());

        scanner.setNewPosition(new Position(3,2));

        assertEquals("Check initial Position",3,scanner.getCurrentPosition().getX());
        assertEquals("Check initial Position",2,scanner.getCurrentPosition().getY());
    }

    @Test (expected = IllegalArgumentException.class)
    public void setNewPositionNullExceptionTest(){
        Scanner scanner = new TwoDimensionsScanner(new Position(1,2),new Position(5,4));

        assertEquals("Check initial Position",1,scanner.getCurrentPosition().getX());
        assertEquals("Check initial Position",2,scanner.getCurrentPosition().getY());

        scanner.setNewPosition(null);
    }

    @Test (expected = IntegerDomainError.class)
    public void setNewPositionOutOfBoundXTest(){
        Scanner scanner = new TwoDimensionsScanner(new Position(1,2),new Position(5,4));

        assertEquals("Check initial Position",1,scanner.getCurrentPosition().getX());
        assertEquals("Check initial Position",2,scanner.getCurrentPosition().getY());

        scanner.setNewPosition(new Position(6,4));
    }

    @Test (expected = IntegerDomainError.class)
    public void setNewPositionOutOfBoundYTest(){
        Scanner scanner = new TwoDimensionsScanner(new Position(1,2),new Position(5,4));

        assertEquals("Check initial Position",1,scanner.getCurrentPosition().getX());
        assertEquals("Check initial Position",2,scanner.getCurrentPosition().getY());

        scanner.setNewPosition(new Position(4,6));
    }

    @Test
    public void resetTest(){
        Scanner scanner = new TwoDimensionsScanner(new Position(1,2),new Position(5,4));

        assertEquals("Check initial Position",1,scanner.getCurrentPosition().getX());
        assertEquals("Check initial Position",2,scanner.getCurrentPosition().getY());

        scanner.setNewPosition(new Position(3,2));

        assertEquals("Check initial Position",3,scanner.getCurrentPosition().getX());
        assertEquals("Check initial Position",2,scanner.getCurrentPosition().getY());

        Position resetPosition = scanner.reset();

        assertEquals("Check initial Position",1,scanner.getCurrentPosition().getX());
        assertEquals("Check initial Position",2,scanner.getCurrentPosition().getY());

        assertEquals("Check initial Position", scanner.getCurrentPosition().getX(), resetPosition.getX());
        assertEquals("Check initial Position", scanner.getCurrentPosition().getY(), resetPosition.getY());
    }

    @Test
    public void switchScanningAxisTest(){
        Scanner scanner = new TwoDimensionsScanner(new Position(1,2),new Position(5,4));

        assertEquals("Scanner axis",scanner.switchScanningAxis(),Axis.Y);
        assertEquals("Scanner axis",scanner.switchScanningAxis(),Axis.X);
        assertEquals("Scanner axis",scanner.switchScanningAxis(),Axis.Y);
        assertEquals("Scanner axis",scanner.switchScanningAxis(),Axis.X);
    }

    @Test
    public void next(){
        Scanner scanner = new TwoDimensionsScanner(new Position(1,2),new Position(5,4));
        Position position = scanner.next();
        assertEquals("Check next logic",2,position.getX());
        assertEquals("Check next logic",2,position.getY());
        position = scanner.next();
        assertEquals("Check next logic",3,position.getX());
        assertEquals("Check next logic",2,position.getY());
        position = scanner.next();
        assertEquals("Check next logic",4,position.getX());
        assertEquals("Check next logic",2,position.getY());
        position = scanner.next();
        assertEquals("Check next logic",5,position.getX());
        assertEquals("Check next logic",2,position.getY());
        position = scanner.next();
        assertEquals("Check next logic",0,position.getX());
        assertEquals("Check next logic",2,position.getY());
        position = scanner.next();
        assertEquals("Check next logic",1,position.getX());
        assertEquals("Check next logic",2,position.getY());

        scanner.switchScanningAxis();
        assertEquals("Check next logic",1,position.getX());
        assertEquals("Check next logic", 2, position.getY());

        position = scanner.next();
        assertEquals("Check next logic",1,position.getX());
        assertEquals("Check next logic",3,position.getY());

        position = scanner.next();
        assertEquals("Check next logic",1,position.getX());
        assertEquals("Check next logic",4,position.getY());

        position = scanner.next();
        assertEquals("Check next logic",1,position.getX());
        assertEquals("Check next logic",0,position.getY());

        position = scanner.next();
        assertEquals("Check next logic",1,position.getX());
        assertEquals("Check next logic",1,position.getY());
    }
}
