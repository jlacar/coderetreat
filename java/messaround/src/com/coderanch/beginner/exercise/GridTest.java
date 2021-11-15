package com.coderanch.beginner.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Test
    void we_can_verify_that_a_location_is_alive() {
        Grid grid = new Grid();

        grid.setAliveAt(0, 0);

        assertTrue(grid.isAliveAt(0, 0));
    }

//    @Test
//    void all_locations_on_a_new_grid_should_be_dead() {
//        Grid grid = new Grid();
//
//        for (Cell cell : grid.cells()) {
//            assertFalse(cell.isAlive());
//        }
//    }
}