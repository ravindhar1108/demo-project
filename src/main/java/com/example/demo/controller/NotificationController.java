package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for Notification Management.
 * 
 * // TODO: Revisit LIN-103 to handle generic type casting safely
 */
@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    @GetMapping("/send")
    public String sendNotification() {
        // BAD PRACTICE: System.out instead of logging framework (Triggers SonarQube Code Smell)
        System.out.println("Starting notification push sequence...");
        
        // VULNERABILITY: Intentional ClassCastException (Triggers Sentry & Slack)
        // Creating an Object array and trying to cast it to a String array
        Object[] genericList = new Object[]{"user1@example.com", 12345};
        String invalidString = (String) genericList[1]; // Will instantly crash here

        return "Notification sent to: " + invalidString;
    }
}
