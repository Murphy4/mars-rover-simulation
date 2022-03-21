package com.mars.rover.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GridParser {

    public List<Integer> parseGridInput(String inputLine) {
        return convertGridInputToIntegerValues(splitGridInputLine(inputLine));
    }

    private List<String> splitGridInputLine(String inputLine) {
        return Arrays.asList(inputLine.split(" "));
    }

    private List<Integer> convertGridInputToIntegerValues(List<String> stringList){
        return stringList
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
