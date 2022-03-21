package com.mars.rover.component;

import com.mars.rover.Application;
import org.junit.Test;

public class RoverSimulationTest {

    private static final String FILEPATH = "src/test/resources/input/rovers_simulation.txt";

    @Test
    public void test_roverSimulationTest() {
        Application.main(new String[]{FILEPATH});
    }
}