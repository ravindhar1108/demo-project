package com.example.demo.vulnerabilities;

import java.io.ObjectInputStream;
import java.io.InputStream;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class DeserializationController {
    
    @PostMapping("/api/user/profile")
    public String updateProfile(HttpServletRequest request) {
        try {
            // VULNERABILITY: Insecure Deserialization
            InputStream is = request.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            Object obj = ois.readObject(); // Unsafe deserialization of untrusted data
            ois.close();
            return "Profile updated.";
        } catch (Exception e) {
            return "Error updating profile.";
        }
    }
}
