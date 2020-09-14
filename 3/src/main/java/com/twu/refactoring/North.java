package com.twu.refactoring;

public class North extends Direction {
    public North() {
        super('N');
    }

    public Direction turnRight() {
        return new East();
    }

    public Direction turnLeft() {
        return new West();
    }
}
