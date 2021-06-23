package com.interview;

import java.util.ArrayList;
import java.util.List;

public class Board<T> {

    List<List<T>> grid = new ArrayList<>();

    public List<List<T>> getGrid() {
        return this.grid;
    }

    public void updateGrid(Location location, T currentPlayer) {
        this.grid.get(location.getI()).set(location.getJ(), currentPlayer);
    }

    public void printBoard() {
        for (int i = 0; i < this.getGrid().size(); i++) {
            for (int j = 0; j < this.getGrid().get(0).size(); j++) {
                System.out.print(this.grid.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public void setup(int horizontalLimit, int verticalLimit, T defaultValue) {

        for (int i = 0; i < horizontalLimit; i++) {
            List<T> group = new ArrayList<>();
            for (int j = 0; j < verticalLimit; j++) {
                group.add(defaultValue);
            }
            this.grid.add(group);
        }
    }
}
