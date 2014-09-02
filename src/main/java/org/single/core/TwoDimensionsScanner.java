package org.single.core;

public class TwoDimensionsScanner implements Scanner {

    private final Position startPosition;
    private final Position maxPosition;
    private Position current;
    private Axis scanningAxis = Axis.X;

    TwoDimensionsScanner(Position initialPosition,Position maxPosition){
        RunTimeChecks.checkNotNull(initialPosition,"Initial Position Object is null");
        RunTimeChecks.checkNotNull(initialPosition,"Max Position Object is null");
        RunTimeChecks.checkWithinIntervalInclusive(
                initialPosition.getX(),
                0,
                maxPosition.getX(),
                "The initial position must be less than the max position for the axis X");
        RunTimeChecks.checkWithinIntervalInclusive(
                initialPosition.getY(),
                0,
                maxPosition.getY(),
                "The initial position must be less than the max position for the axis Y");
        this.startPosition = initialPosition;
        this.maxPosition = maxPosition;
        this.current = initialPosition;
    }

    /* TODO */
    @Override
    public Position next() {
        return null;
    }

    @Override
    public Position reset() {
        current = startPosition;
        return current;
    }

    @Override
    public void setNewPosition(Position position) {
        RunTimeChecks.checkNotNull(position,"Input Position object is null");
        RunTimeChecks.checkWithinIntervalInclusive(
                position.getX(),
                0,
                maxPosition.getX(),
                "The initial position must be less than the max position for the axis X");
        RunTimeChecks.checkWithinIntervalInclusive(
                position.getY(),
                0,
                maxPosition.getY(),
                "The initial position must be less than the max position for the axis Y");
        current = position;
    }

    @Override
    public Position getCurrentPosition() {
        return current;
    }

    @Override
    public Axis switchScanningAxis() {
        if (scanningAxis==Axis.X){
            scanningAxis = Axis.Y;
        } else{
            scanningAxis = Axis.X;
        }
        return scanningAxis;
    }
}
