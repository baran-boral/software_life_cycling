package java.org.example;

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
        cells[row][col] = marker;
    }
}