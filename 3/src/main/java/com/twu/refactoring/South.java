package com.twu.refactoring;

public class South extends Direction {
    public South() {
        super('S');
    }

    public Direction turnRight() {
        return new West();
    }

    public Direction turnLeft() {
        return new East();
    }
}
