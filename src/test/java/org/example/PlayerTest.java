package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    Player player;

    @BeforeEach
    void setUp() {
        player = new Player('X');
    }

    @Test
    void markerShouldBeX() {

        assertEquals(
                'X',
                player.getMarker()
        );
    }

}