package org.single.core;

public interface Scanner {

    Position next();

    Position reset();

    void setNewPosition(Position position);

    Position getCurrentPosition();

    Axis switchScanningAxis();
}
