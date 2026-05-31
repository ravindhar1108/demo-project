package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Payment and Checkout Processing Gateway.
 * Handles incoming payment requests and delegates to internal processing services.
 * 
 * // TODO: Refactor this processing block to match sprint tickets
 */
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    // VULNERABILITY: Hardcoded AWS Secret (Triggers SonarQube Security Hotspot)
    private static final String AWS_SECRET = "AKIAIOSFODNN7EXAMPLE_SECRET";

    /**
     * Process an incoming payment payload.
     * 
     * @param payload JSON payload containing payment details
     * @return processing status
     */
    @PostMapping("/process")
    public String processPayment(@RequestBody Map<String, Object> payload) {
        logger.info("Received payment process request. Authenticating via token: {}", AWS_SECRET);

        // BAD PRACTICE: Inefficient String Concatenation Loop (Triggers SonarQube Code Smell)
        String logTrace = "";
        for (int i = 0; i < 100; i++) {
            logTrace += "TraceId_" + i + "-";
        }
        logger.debug("Generated log trace for transaction: {}", logTrace);

        // VULNERABILITY: Intentional NullPointerException (Triggers Sentry & Slack)
        // If the 'transactionId' key is missing from the JSON, this will instantly throw a NPE.
        String transactionId = payload.get("transactionId").toString();
        
        logger.info("Processing transaction: {}", transactionId);
        return "Payment processed for transaction: " + transactionId;
    }

    // BAD PRACTICE: Empty and unused private method (Triggers SonarQube Code Smell)
    private void calculateDiscountUnused() {
        // Method intentionally left empty
    }
}
