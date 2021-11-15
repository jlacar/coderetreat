package com.jlacar;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Rules:
 * 1. Alive and < 2 neighbors, dies from loneliness
 * 2. Alive and > 3 neighbors, dies from overpopulation
 * 3. Alive and 2-3 neighbors, lives to next generation
 * 4. Empty and exactly 3 neighbors, alive in next generation
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GameOfLifeTest {

    // Zero case
    @Test
    void empty_world_will_not_be_evolving() {
        GameOfLife world = new GameOfLife();
        assertFalse( world.isEvolving() );
    }

    void storyBoard() {
        GameOfLife world = new GameOfLife();
        // populate the world
        while (world.isEvolving()) {
            display(world);
            world.evolve();
        }
        // done
    }

    private void display(GameOfLife world) {

    }

}