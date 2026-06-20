package org.example;

public class Board {
    private final char[][] cells;

    public Board() {
        cells = new char[3][3];
    }

    public boolean isCellEmpty(int row, int col) {
        return cells[row][col] == '\0';
    }

    public void place(int row, int col, char marker) {
        if (!isCellEmpty(row, col)) {
            throw new IllegalArgumentException("Cell already occupied");
        }
        cells[row][col] = marker;
    }

    public char getCell(int row, int col) {
        return cells[row][col];
    }

    public boolean hasWinner() {
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] != '\0' && cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2]) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (cells[0][i] != '\0' && cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i]) {
                return true;
            }
        }

        if (cells[0][0] != '\0' && cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2]) {
            return true;
        }

        if (cells[0][2] != '\0' && cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0]) {
            return true;
        }

        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    public void display() {
        System.out.println("▁▁▁▁▁▁");
        for (int i = 0; i < 3; i++) {
            System.out.println("| " + (cells[i][0] == '\0' ? ' ' : cells[i][0]) + " | "
                    + (cells[i][1] == '\0' ? ' ' : cells[i][1]) + " | "
                    + (cells[i][2] == '\0' ? ' ' : cells[i][2]) + " |");
        }
        System.out.println("▔▔▔▔");
    }
}