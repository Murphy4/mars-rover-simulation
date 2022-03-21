package com.mars.rover.controller;

import com.mars.rover.model.Grid;

import java.util.List;

public class GridController {
    private static Grid grid;

    public GridController() {
        grid = new Grid();
    }

    public static Grid getGrid() {
        return grid;
    }

    public void createGrid(List<Integer> gridSizes) {
        grid.setWidth(gridSizes.get(0));
        grid.setHeight(gridSizes.get(1));
    }


}
