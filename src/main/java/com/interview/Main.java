package com.interview;

public class Main {

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.initBoard();

        while (ticTacToe.isBoardEmpty()) {
            try {
                TicTacToeStatus ticTacToeStatus = ticTacToe.nextStep();
                if (ticTacToeStatus.isWinner()) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        if (ticTacToe.getWinner() > -1) {
            System.out.println("Winner is player " + (ticTacToe.getWinner() + 1));
        }
    }
}
