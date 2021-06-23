/*
 *  DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 *  Copyright (c) 2019. Whizdm Innovations Private Limited and/or its affiliates.
 *  All rights reserved.
 *  Use is subject to license terms.
 *
 */

package com.interview;

/**
 * Created on 23/6/21, 3:12 PM
 * TicTacToeStatus.java
 *
 * @author aditya.misra
 */

public enum TicTacToeStatus {

    boardEmpty(-1),
    playerZero(0),
    playerOne(1),
    boardComplete(2);

    private int status;

    TicTacToeStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public boolean isWinner() {
        return this.getStatus() == 0 || this.getStatus() == 1;
    }
}
