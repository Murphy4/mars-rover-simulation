package com.mars.rover.unit.service;

import com.mars.rover.service.GridParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GridParserServiceTest {
    GridParser gridParser;

    @Before
    public void setUp() {
        gridParser = new GridParser();
    }

    @Test
    public void test_gridParser_withGridInput_ShouldReturnListGridSizes() {
        //given
        String string = "4 8";
        //when
        List<Integer> actualGridInput = gridParser.parseGridInput(string);
        //then
        ArrayList<Integer> expectedGridInput = new ArrayList<>();
        expectedGridInput.add(4);
        expectedGridInput.add(8);

        Assert.assertEquals(expectedGridInput, actualGridInput);
    }
}

