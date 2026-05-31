package com.example.demo.vulnerabilities;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AwsIntegrationController {
    @GetMapping("/api/aws/keys")
    public String getAwsKeys() {
        // VULNERABILITY: Hardcoded AWS Credentials
        String awsAccessKey = "AKIAIOSFODNN7EXAMPLE";
        String awsSecretKey = "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY";
        return "AWS setup initialized.";
    }
}
