package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    Board board;

    @BeforeEach
    void setUp(){
        board = new Board();
    }

    @Test
    void cellShouldBeEmptyInitially(){
        assertTrue(
                board.isCellEmpty(0,0)
        );
    }
    @Test
    void cellShouldNotBeEmptyAfterPlace(){
        board.place(0,0,'X');

        assertFalse(board.isCellEmpty(0,0));
    }

    @Test
    void placeOnOccupiedCell() {

        board.place(0,0,'X');

        assertThrows(
                IllegalArgumentException.class,
                () -> board.place(0,0,'O')
        );
    }

}
