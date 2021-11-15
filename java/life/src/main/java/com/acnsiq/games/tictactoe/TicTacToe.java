package com.acnsiq.games.tictactoe;

import java.util.Arrays;

public class TicTacToe {

    public static final char X = 'X';
    public static final char O = 'O';
    public static final char NONE = '-';

    private static final int[] ROW_1 = {0, 1, 2};
    private static final int[] ROW_2 = {3, 4, 5};
    private static final int[] ROW_3 = {6, 7, 8};

    private static final int[] COL_1 = {0, 3, 6};
    private static final int[] COL_2 = {1, 4, 7};
    private static final int[] COL_3 = {2, 5, 8};

    private static final int[] DIAGONAL_1 = {0, 4, 8};
    private static final int[] DIAGONAL_2 = {6, 4, 2};

    private final char[] board;

    private char whoMoves;
    private char winner;

    public TicTacToe() {
        this(X);
    }

    public TicTacToe(char player) {
        if (isNotValidFirstMove(player)) {
            throw new IllegalArgumentException(String.format("Player has to be either '%s' or '%s'", X, O));
        }

        board = newBoard();
        setFirstMove(player);
        winner = NONE;
    }

    private boolean isNotValidFirstMove(char player) {
        return !(player == X || player == O);
    }

    private void setFirstMove(char player) {
        whoMoves = player;
    }

    private char[] newBoard() {
        char[] board = new char[9];
        Arrays.fill(board, NONE);
        return board;
    }

    public void play(int[] moves) {
        for (int position : moves) {
            move(position);
        }
    }

    public void move(int position) {
        if (cantMark(position)) {
            return;
        }

        mark(position);
        updateGameState();
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%s%n", asString(ROW_1), asString(ROW_2), asString(ROW_3));
    }

    private String asString(int[] position) {
        return String.format("%s %s %s", board[position[0]], board[position[1]], board[position[2]]);
    }

    public boolean isDraw() {
        return noWinner() && allSpacesMarked();
    }

    public boolean isOver() {
        return hasWinner() || isDraw();
    }

    public char winner() {
        return winner;
    }

    char getMarkAt(int position) {
        return board[position];
    }

    private void mark(int position) {
        board[position] = whoMoves;
    }

    private void updateGameState() {
        checkForWinner();

        if (noWinner() && hasUnmarkedSpace()) {
            switchTurn();
        }
    }

    private boolean hasUnmarkedSpace() {
        for (char mark : board) {
            if (mark == NONE) {
                return true;
            }
        }
        return false;
    }

    private boolean allSpacesMarked() {
        return !hasUnmarkedSpace();
    }

    private void checkForWinner() {
        if (wonOnRow() || wonOnColumn() || wonOnDiagonal()) {
            winner = whoMoves;
        }
    }

    private boolean wonOnRow() {
        return wonOn(ROW_1) || wonOn(ROW_2) || wonOn(ROW_3);
    }

    private boolean wonOnColumn() {
        return wonOn(COL_1) || wonOn(COL_2) || wonOn(COL_3);
    }

    private boolean wonOnDiagonal() {
        return wonOn(DIAGONAL_1) || wonOn(DIAGONAL_2);
    }

    private boolean wonOn(int[] positions) {
        return completed(positions[0], positions[1], positions[2]);
    }

    private boolean noWinner() {
        return winner == NONE;
    }

    private boolean completed(int position1, int position2, int position3) {
        return isMarked(position1) &&
                getMarkAt(position1) == getMarkAt(position2) &&
                getMarkAt(position1) == getMarkAt(position3);
    }

    private boolean hasWinner() {
        return winner != NONE;
    }

    private boolean isMarked(int position) {
        return board[position] != NONE;
    }

    private void switchTurn() {
        whoMoves = (whoMoves == X) ? O : X;
    }

    private boolean cantMark(int position) {
        return !canMark(position);
    }

    public boolean canMark(int position) {
        return !(isOver() || isMarked(position));
    }
}
