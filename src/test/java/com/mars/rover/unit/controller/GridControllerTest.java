package com.mars.rover.unit.controller;

import com.mars.rover.controller.GridController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


public class GridControllerTest {
    GridController gridController;

    @Before
    public void setUp() {
        gridController = new GridController();
    }

    @Test
    public void test_gridController_withGridSizeString_shouldUpdateGrid() {
        // given
        ArrayList<Integer> expectedGridInput = new ArrayList<>();
        expectedGridInput.add(4);
        expectedGridInput.add(8);
        // when
        gridController.createGrid(expectedGridInput);
        // then
        Assert.assertEquals(4, GridController.getGrid().getWidth());
        Assert.assertEquals(8, GridController.getGrid().getHeight());
    }
}
