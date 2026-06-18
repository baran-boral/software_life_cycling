package org.example;

public class Board {
    private final char[][] cells;

    public Board() {
        cells = new char[3][3]; // 3x3 Tic-Tac-Toe
        // Alle Felder sind standardmäßig '\0', das behandeln wir als "leer"
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