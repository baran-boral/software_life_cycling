package org.example;

import java.util.Scanner;

public class TicTacToe {

    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Board board;

    public TicTacToe() {
        this.player1 = new Player('X');
        this.player2 = new Player('O');
        this.currentPlayer = player1;
        this.board = new Board();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        boolean moveDone = false;
        while (!moveDone) {
            System.out.println("Current player: " + currentPlayer.getMarker());

            System.out.print("Enter row (0-2): ");
            int row = scanner.nextInt();

            System.out.print("Enter column (0-2): ");
            int col = scanner.nextInt();

            // einfache Bounds-Prüfung, damit nichts crasht
            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Row/column must be between 0 and 2. Try again.");
                continue;
            }

            if (!board.isCellEmpty(row, col)) {
                System.out.println("Cell is not empty. Choose another one.");
                continue;
            }

            // Feld ist leer -> Zug ausführen
            board.place(row, col, currentPlayer.getMarker());
           // moveDone = true;

            // aktueller Spieler wechselt
            switchCurrentPlayer();
            System.out.println("Next player: " + currentPlayer.getMarker());
        }
        scanner.close();
    }

    private void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
}