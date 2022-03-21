package com.mars.rover.service;

import java.util.List;
import java.util.stream.Collectors;

public class RoverParser {

    public List<String> parseInitialRoverPlacements(List<String> roverInputString) {
        return roverInputString
                .stream()
                .map(RoverParser::getInitialPlacementString)
                .collect(Collectors.toList());
    }

    private static String getInitialPlacementString(String roverInputString) {
        return roverInputString.substring(1, roverInputString.indexOf(")"));
    }


    public List<String> parseRoverMovementCommands(List<String> roverInputString) {
        return roverInputString
                .stream()
                .map(RoverParser::getRoverMovementCommands)
                .collect(Collectors.toList());
    }

    private static String getRoverMovementCommands(String roverInputString) {
        return roverInputString.substring(roverInputString.indexOf(") ") + 2);
    }
}
