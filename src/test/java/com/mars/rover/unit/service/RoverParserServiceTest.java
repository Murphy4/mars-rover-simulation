package com.mars.rover.unit.service;

import com.mars.rover.service.RoverParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RoverParserServiceTest {
    RoverParser roverParser;

    @Before
    public void setUp() {
        roverParser = new RoverParser();
    }

    @Test
    public void test_roverParser_withRoverStringInputLines_parsesInitialPlacements() {
        //given
        ArrayList<String> roverStringInputLines = new ArrayList<>();
        roverStringInputLines.add("(2, 3, E) LFRFF");
        roverStringInputLines.add("(0, 2, N) FFLFRFF");

        //when
        List<String> roverStringInitialPlacementLines = roverParser.parseInitialRoverPlacements(roverStringInputLines);

        //then
        ArrayList<String> expectedRoverInitialPlacementInput = new ArrayList<>();
        expectedRoverInitialPlacementInput.add("2, 3, E");
        expectedRoverInitialPlacementInput.add("0, 2, N");
        Assert.assertEquals(expectedRoverInitialPlacementInput, roverStringInitialPlacementLines);
    }

    @Test
    public void test_roverParser_withRoverStringInputLines_parsesMovementCommands() {
        //given
        ArrayList<String> roverStringInputLines = new ArrayList<>();
        roverStringInputLines.add("(2, 3, E) LFRFF");
        roverStringInputLines.add("(0, 2, N) FFLFRFF");

        //when
        List<String> roverStringMovementCommands = roverParser.parseRoverMovementCommands(roverStringInputLines);

        //then
        ArrayList<String> expectedRoverInitialPlacementInput = new ArrayList<>();
        expectedRoverInitialPlacementInput.add("LFRFF");
        expectedRoverInitialPlacementInput.add("FFLFRFF");
        Assert.assertEquals(expectedRoverInitialPlacementInput, roverStringMovementCommands);
    }
}
