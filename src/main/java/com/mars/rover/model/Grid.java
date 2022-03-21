package com.mars.rover.model;

public class Grid {
    private int width;
    private int Height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    @Override
    public String toString() {
        return "Grid{" +
                "width=" + width +
                ", Height=" + Height +
                '}';
    }
}
