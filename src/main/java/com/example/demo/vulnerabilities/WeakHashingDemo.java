package com.example.demo.vulnerabilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class WeakHashingDemo {
    public String hashPassword(String password) {
        try {
            // VULNERABILITY: Weak Hash Algorithm (MD5)
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashInBytes = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashInBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
