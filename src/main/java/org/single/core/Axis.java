package org.single.core;

public enum Axis {
    X("X"),
    Y("Y");

    private String value;

    private Axis(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Axis{" +
                "String=" + value +
                '}';
    }
}
