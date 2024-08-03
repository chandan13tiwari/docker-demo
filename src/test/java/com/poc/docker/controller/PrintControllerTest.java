package com.poc.docker.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PrintControllerTest {

    @InjectMocks
    PrintController printController;

    @Test
    void testAddedTimeDelay() throws InterruptedException {
        // added time delay to slow down mvn clean to showcase docker compose
        String expectedResult = "Process Completed";
        String actualResult = printController.addedTimeDelay(120000); // delay for 2min

        Assertions.assertEquals(expectedResult, actualResult);
    }

}
