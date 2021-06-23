package com.interview;

public class IntelligentMoveGenerator {

    public static int randomInt() {
        return (int) Math.random() * 3;
    }
    public static Location nextMove() {
        return new Location(randomInt(), randomInt());
    }
}
