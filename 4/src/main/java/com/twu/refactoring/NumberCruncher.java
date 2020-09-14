package com.twu.refactoring;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return dataProcessing(number -> number % 2 == 0);
    }

    public int countOdd() {
        return dataProcessing(number -> number % 2 == 1);
    }

    public int countPositive() {
        return dataProcessing(number -> number >= 0);
    }

    public int countNegative() {
        return dataProcessing(number -> number < 0);
    }

    public int dataProcessing(Predicate<Integer> function) {
        int count = 0;
        for (int number : numbers) {
            if (function.test(number)) count++;
        }
        return count;
    }
}
