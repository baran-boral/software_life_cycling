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

}