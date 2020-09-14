package com.twu.refactoring;

public class East extends Direction {
    public East() {
        super('E');
    }

    public Direction turnRight() {
        return new South();
    }

    public Direction turnLeft() {
        return new North();
    }
}
