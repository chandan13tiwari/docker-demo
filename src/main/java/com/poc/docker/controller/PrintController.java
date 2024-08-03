package com.poc.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrintController {

    @GetMapping("/name/{yourName}")
    public String printName(@PathVariable("yourName") String yourName) {
        return yourName;
    }

    @GetMapping("/delay/time/{delayTime}")
    public String addedTimeDelay(@PathVariable("delayTime") int delayTime) throws InterruptedException {
        System.out.println("We are going to take " + delayTime + " millis to process this method...");
        Thread.sleep(delayTime);
        System.out.println("Process completed!!");
        return "Process Completed";
    }
}
