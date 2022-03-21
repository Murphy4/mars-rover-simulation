package com.mars.rover;

import com.mars.rover.controller.GridController;
import com.mars.rover.controller.RoverController;
import com.mars.rover.model.Rover;
import com.mars.rover.service.GridParser;
import com.mars.rover.service.RoverParser;

import java.util.ArrayList;
import java.util.List;

import static com.mars.rover.service.SimulationInputService.getRoverSimulationInput;

public class Application {
    public static void main(String[] args) {

        ArrayList<String> roverSimulationInput = getRoverSimulationInput(args[0]);

        String gridStringInputLine = roverSimulationInput.get(0);
        GridParser gridParser = new GridParser();
        List<Integer> gridInputs = gridParser.parseGridInput(gridStringInputLine);

        GridController gridController = new GridController();
        gridController.createGrid(gridInputs);

        List<String> roverStringInputLines = roverSimulationInput.subList(1, roverSimulationInput.size());
        RoverParser roverParser = new RoverParser();
        List<String> roverInitialPlacementLines = roverParser.parseInitialRoverPlacements(roverStringInputLines);

        List<Rover> rovers = RoverController.createRovers(roverInitialPlacementLines);
        List<String> roverMovementCommands = roverParser.parseRoverMovementCommands(roverStringInputLines);

        RoverController.commandRoverToMove(rovers.get(0), roverMovementCommands.get(0));
        RoverController.commandRoverToMove(rovers.get(1), roverMovementCommands.get(1));

        for (Rover rover : rovers) {
            System.out.println(rover.toString());
        }
    }
}

