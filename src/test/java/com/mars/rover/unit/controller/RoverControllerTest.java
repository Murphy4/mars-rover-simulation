package com.mars.rover.unit.controller;

import com.mars.rover.controller.RoverController;
import com.mars.rover.model.Rover;
import com.mars.rover.type.Directions;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.mars.rover.type.Directions.*;
import static com.mars.rover.type.RoverStatus.LOST;
import static com.mars.rover.type.RoverStatus.SAFE;

public class RoverControllerTest {

    @Test
    public void test_roverController_withRoverInputList_shouldCreateRovers() {
        // given
        String roverString1 = "7, 0, W";
        String roverString2 = "2, 3, S";
        ArrayList<String> roversStringList = new ArrayList<>();
        roversStringList.add(roverString1);
        roversStringList.add(roverString2);

        // when
        List<Rover> rovers = RoverController.createRovers(roversStringList);

        // then
        Assert.assertNotNull(rovers);
        Assert.assertEquals(2, rovers.size());
        Assert.assertEquals(new Rover(7, 0, W).toString(), rovers.get(0).toString());
        Assert.assertEquals(new Rover(2, 3, Directions.S).toString(), rovers.get(1).toString());
    }

    @Test
    public void test_roverController_withMovementCommands_shouldMoveRover() {
        //given
        Rover rover = new Rover(2, 3, E);
        Rover lostRover = new Rover(1, 0, S);

        //when
        RoverController.commandRoverToMove(rover, "LFRFF");
        RoverController.commandRoverToMove(lostRover, "FFRLF");

        //then
        Assert.assertEquals(E, rover.getDirection());
        Assert.assertEquals(4, rover.getXCoordinate());
        Assert.assertEquals(4, rover.getYCoordinate());
        Assert.assertEquals(SAFE, rover.getStatus());

        Assert.assertEquals(S, lostRover.getDirection());
        Assert.assertEquals(1, lostRover.getXCoordinate());
        Assert.assertEquals(0, lostRover.getYCoordinate());
        Assert.assertEquals(LOST, lostRover.getStatus());
    }
}
