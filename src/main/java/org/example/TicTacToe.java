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
        board.display();

        boolean gameOver = false;
        while (!gameOver) {
            System.out.println("Current player: " + currentPlayer.getMarker());

            System.out.print("Enter row (0-2): ");
            int row = scanner.nextInt();

            System.out.print("Enter column (0-2): ");
            int col = scanner.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Row/column must be between 0 and 2. Try again.");
                continue;
            }

            if (!board.isCellEmpty(row, col)) {
                System.out.println("Cell is not empty. Choose another one.");
                continue;
            }

            board.place(row, col, currentPlayer.getMarker());
            board.display();

            if (board.hasWinner()) {
                System.out.println("Game over! Player " + currentPlayer.getMarker() + " wins!");
                gameOver = !askPlayAgain(scanner);
            } else if (board.isFull()) {
                System.out.println("Game over! It's a draw.");
                gameOver = !askPlayAgain(scanner);
            } else {
                switchCurrentPlayer();
                System.out.println("Next player: " + currentPlayer.getMarker());
            }
        }

        scanner.close();
    }

    private boolean askPlayAgain(Scanner sc) {
        System.out.print("Play again? (y/n): ");
        String answer = sc.next();
        if (answer.equalsIgnoreCase("y")) {
            reset();
            board.display();
            return true;
        }
        return false;
    }

    private void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
    public void reset() {
        this.board.reset();
        this.currentPlayer = player1;
    }
}