package com.mars.rover.controller;

import com.mars.rover.model.Rover;
import com.mars.rover.type.Directions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.mars.rover.type.Directions.*;
import static com.mars.rover.type.RoverStatus.LOST;

public class RoverController {
    public static List<Rover> createRovers(List<String> roversInput) {
        return roversInput.stream()
                .map(RoverController::createRover)
                .collect(Collectors.toList());
    }

    private static Rover createRover(String initialRoverPlacement) {
        List<String> initialRoverPlacements = parseInitialRoverPlacement(initialRoverPlacement);

        Rover rover = new Rover();
        String xString = initialRoverPlacements.get(0);
        String yString = initialRoverPlacements.get(1);
        String directionCode = initialRoverPlacements.get(2);

        rover.setXCoordinate(Integer.parseInt(xString));
        rover.setYCoordinate(Integer.parseInt(yString));
        rover.setDirection(Directions.valueOf(directionCode));

        return rover;
    }

    public static void commandRoverToMove(Rover rover, String movementCommands) {
        List<String> movementCommandList = Arrays.stream(movementCommands.split("")).collect(Collectors.toList());
        for (String movementCommand : movementCommandList) {
            moveRover(rover, movementCommand);
            if (rover.getStatus().equals(LOST)) break;
        }
    }

    public static void moveRover(Rover rover, String movementCommand) {
        switch (movementCommand) {
            case "F":
                moveRoverForward(rover);
                break;
            case "L":
                rotateRoverAntiClockwise(rover);
                break;
            case "R":
                rotateRoverClockwise(rover);
                break;
        }
    }

    public static void moveRoverForward(Rover rover) {
        switch (rover.getDirection()) {
            case N:
                int nextYCoordinate = rover.getYCoordinate() + 1;
                if (nextYCoordinate > GridController.getGrid().getHeight()) {
                    rover.setStatus(LOST);
                    return;
                }
                rover.setYCoordinate(nextYCoordinate);
                break;
            case S:
                nextYCoordinate = rover.getYCoordinate() - 1;
                if (nextYCoordinate < 0) {
                    rover.setStatus(LOST);
                    return;
                }
                rover.setYCoordinate(nextYCoordinate);
                break;
            case E:
                int nextXCoordinate = rover.getXCoordinate() + 1;
                if (nextXCoordinate > GridController.getGrid().getWidth()) {
                    rover.setStatus(LOST);
                    return;
                }
                rover.setXCoordinate(nextXCoordinate);
                break;
            case W:
                nextXCoordinate = rover.getXCoordinate() - 1;
                if (nextXCoordinate < 0) {
                    rover.setStatus(LOST);
                    return;
                }
                rover.setXCoordinate(nextXCoordinate);
                break;
        }
    }


    private static void rotateRoverAntiClockwise(Rover rover) {
        switch (rover.getDirection()) {
            case N:
                rover.setDirection(W);
                break;
            case S:
                rover.setDirection(E);
                break;
            case E:
                rover.setDirection(N);
                break;
            case W:
                rover.setDirection(S);
                break;
        }
    }

    private static void rotateRoverClockwise(Rover rover) {
        switch (rover.getDirection()) {
            case N:
                rover.setDirection(E);
                break;
            case S:
                rover.setDirection(W);
                break;
            case E:
                rover.setDirection(S);
                break;
            case W:
                rover.setDirection(N);
                break;
        }
    }


    private static List<String> parseInitialRoverPlacement(String initialRoverPlacement) {
        return Arrays.asList(initialRoverPlacement.split(", "));
    }
}
