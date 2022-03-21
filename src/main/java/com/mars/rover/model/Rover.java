package com.mars.rover.model;

import com.mars.rover.type.Directions;
import com.mars.rover.type.RoverStatus;

public class Rover {
    private int xCoordinate;
    private int yCoordinate;
    private Directions direction;
    private RoverStatus status;

    public Rover(){
        this.status = RoverStatus.SAFE;
    }

    public Rover(int x, int y, Directions direction) {
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.direction = direction;
        this.status = RoverStatus.SAFE;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    public RoverStatus getStatus() {
        return status;
    }

    public void setStatus(RoverStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "(" + xCoordinate +
                ", " + yCoordinate +
                ", " + direction +
                "), " + status;
    }
}
