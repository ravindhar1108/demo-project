package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for User Management.
 * 
 * // TODO: Need to sync this user profile fetching logic with Linear ticket LIN-101
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    // VULNERABILITY: Hardcoded IP Address (Triggers SonarQube Security Hotspot)
    private static final String DATABASE_IP = "192.168.1.100";

    @GetMapping("/details/{id}")
    public String getUserDetails(@PathVariable String id) {
        logger.info("Fetching user details for ID: {} from DB IP: {}", id, DATABASE_IP);

        // BAD PRACTICE: System.out instead of logger (Triggers SonarQube Code Smell)
        System.out.println("Processing user request...");

        // VULNERABILITY: Intentional ArithmeticException (Triggers Sentry & Slack)
        // Divide by zero will instantly throw ArithmeticException
        int calculateMetrics = 100 / 0;

        return "User details retrieved successfully. Metrics: " + calculateMetrics;
    }
}
