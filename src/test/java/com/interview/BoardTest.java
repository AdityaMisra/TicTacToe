package com.interview;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BoardTest {

    @Test
    public void testGrid() {
        Board board = new Board();
        List<List<Integer>> grid = board.getGrid();

        assertThat(grid.get(0).get(0), is(-1));
    }
}