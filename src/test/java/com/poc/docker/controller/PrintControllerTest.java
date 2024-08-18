package com.poc.docker.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@TestPropertySource("classpath:application-test.properties")
public class PrintControllerTest {

    @InjectMocks
    PrintController printController;

    @Value("${delay-time}")
    int delayTime;

    @Test
    void testAddedTimeDelay() throws InterruptedException {
        // added time delay to slow down mvn clean to showcase docker compose
        String expectedResult = "Process Completed";
        System.out.println(delayTime);
        String actualResult = printController.addedTimeDelay(delayTime); // delay for 2min

        Assertions.assertEquals(expectedResult, actualResult);
    }

}
