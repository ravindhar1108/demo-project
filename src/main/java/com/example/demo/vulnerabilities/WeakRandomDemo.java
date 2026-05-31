package com.example.demo.vulnerabilities;

import java.util.Random;

public class WeakRandomDemo {
    public String generateToken() {
        // VULNERABILITY: Insecure Randomness (java.util.Random instead of SecureRandom)
        Random random = new Random();
        int token = random.nextInt(1000000);
        return String.valueOf(token);
    }
}
