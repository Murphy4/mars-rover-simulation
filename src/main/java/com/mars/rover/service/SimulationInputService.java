package com.mars.rover.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimulationInputService {
    private static final String WORKING_DIRECTORY = System.getProperty("user.dir");
    private static final ArrayList<String> FILE_LINES_LIST = new ArrayList<>();

    public static ArrayList<String> getRoverSimulationInput(String filepath){
        try {
            getFileLines(WORKING_DIRECTORY, filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FILE_LINES_LIST;
    }

    private static void getFileLines(String workingDirectory, String filePath) throws IOException {
        String completeFilePath = String.format("%s/%s", workingDirectory, filePath);
        Stream<String> linesStream = Files.lines(Paths.get(completeFilePath));
        linesStream.collect(Collectors.toCollection(() -> FILE_LINES_LIST));
    }
}
