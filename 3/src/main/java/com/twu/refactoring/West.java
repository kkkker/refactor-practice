package com.twu.refactoring;

public class West extends Direction {
    public West() {
        super('W');
    }

    public Direction turnRight() {
        return new North();
    }

    public Direction turnLeft() {
        return new South();
    }
}
