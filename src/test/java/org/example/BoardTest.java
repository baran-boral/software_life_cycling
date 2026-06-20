package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void cellShouldBeEmptyInitially() {
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void cellShouldNotBeEmptyAfterPlace() {
        board.place(0, 0, 'X');

        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    void placeOnOccupiedCell() {
        board.place(0, 0, 'X');

        assertThrows(
                IllegalArgumentException.class,
                () -> board.place(0, 0, 'O')
        );
    }

    @Test
    void displayShouldShowPlacedSymbols() {
        board.place(0, 0, 'X');
        board.place(1, 1, 'O');

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        board.display();

        String output = outputStream.toString();

        assertTrue(output.contains("X"));
        assertTrue(output.contains("O"));
    }

    @Test
    void displayShouldNotShowSymbolIfNotPlaced() {
        board.place(0, 0, 'X');

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        board.display();

        String output = outputStream.toString();

        assertTrue(output.contains("X"));
        assertFalse(output.contains("O"));
    }

    @Test
    void displayShouldShowEmptyBoardInitially() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        board.display();

        String output = outputStream.toString();

        assertTrue(output.contains("|   |   |   |"));
    }
    @Test
    void shouldDetectVerticalWinner() {
        board.place(0, 0, 'X');
        board.place(1, 0, 'X');
        board.place(2, 0, 'X');

        assertTrue(board.hasWinner());
    }


//Detect Winner Tests
    @Test
    void shouldDetectHorizontalWinner() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'X');

        assertTrue(board.hasWinner());
    }

    @Test
    void shouldDetectMainDiagonalWinner() {
        board.place(0, 0, 'X');
        board.place(1, 1, 'X');
        board.place(2, 2, 'X');

        assertTrue(board.hasWinner());
    }

    @Test
    void shouldDetectAntiDiagonalWinner() {
        board.place(0, 2, 'X');
        board.place(1, 1, 'X');
        board.place(2, 0, 'X');

        assertTrue(board.hasWinner());
    }

    @Test
    void shouldNotDetectWinner() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'O');
        board.place(0, 2, 'X');

        board.place(1, 0, 'O');
        board.place(1, 1, 'X');
        board.place(1, 2, 'O');

        board.place(2, 0, 'O');
        board.place(2, 1, 'X');
        board.place(2, 2, 'O');

        assertFalse(board.hasWinner());
    }

    @Test
    void shouldNotDetectWinnerOnEmptyBoard() {
        assertFalse(board.hasWinner());
    }
}