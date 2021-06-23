package com.interview;

import java.util.List;

public class TicTacToe extends Reader {
    private Board board;
    private int currentPlayer = 0;
    private boolean singlePlayer = false;

    private int winner = -1;

    private void init(Board board, boolean singlePlayer) {
        this.board = board;
        this.singlePlayer = singlePlayer;
    }

    public TicTacToeStatus nextStep() throws Exception {
        this.board.printBoard();

        System.out.println("Move for player " + (currentPlayer + 1));

        TicTacToeStatus status;
        if (currentPlayer == 1 && singlePlayer) {
            Location location = IntelligentMoveGenerator.nextMove();
            status = updateBoard(location);
        } else {
            Location location = new Location(readInt(), readInt());
            status = updateBoard(location);
        }
        currentPlayer = currentPlayer == 0 ? 1 : 0;

        return status;
    }

    private TicTacToeStatus updateBoard(Location location) throws Exception {

        List<List<Integer>> grid = this.board.getGrid();

        if (grid.get(location.getI()).get(location.getJ()) != -1) {
            throw new Exception("Invalid Move. Please try again.");
        }

        this.board.updateGrid(location, currentPlayer);

        int finishedStatus = this.isFinished(location, currentPlayer);

        switch (finishedStatus) {
            case 0:
                return TicTacToeStatus.playerZero;

            case 1:
                return TicTacToeStatus.playerOne;

            case -1:
                return TicTacToeStatus.boardEmpty;

            default:
                return TicTacToeStatus.boardComplete;
        }
    }

    public void initBoard() {
        Board board = new Board();
        board.setup(3, 3, -1);

        System.out.println("Single Player? ");
        if (readInt() == 0) {
            this.init(board, false);
        } else {
            this.init(board, true);
        }
    }

    public boolean isBoardEmpty() {

        List<List<Integer>> grid = this.board.getGrid();

        int verticalLength = grid.get(0).size();

        for (List<Integer> integers : grid) {
            for (int j = 0; j < verticalLength; j++) {
                if (integers.get(j) == -1) {
                    return true;
                }
            }
        }
        return false;
    }

    private int isFinished(Location location, int currentPlayer) {

        if (isWinner(location, currentPlayer)) {
            return this.getWinner();
        }

        if (isBoardEmpty()) {
            return -1;
        }
        return 2;
    }

    private boolean isWinner(Location location, int currentPlayer) {

        List<List<Integer>> grid = this.board.getGrid();
//        int horizontalLength = grid.size();
        int verticalLength = grid.get(0).size();

        int locationI = location.getI();

        for (int j = 0; j < verticalLength; j++) {
            if (grid.get(locationI).get(j) != currentPlayer) {
                return false;
            }
        }

        this.winner = currentPlayer;
        return true;
    }

    public int getWinner() {
        return this.winner;
    }
}
