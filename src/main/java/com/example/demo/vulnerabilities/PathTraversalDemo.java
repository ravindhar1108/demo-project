package com.example.demo.vulnerabilities;

import java.io.File;

public class PathTraversalDemo {
    public void deleteFile(String filename) {
        // VULNERABILITY: Path Traversal
        File file = new File("/var/www/uploads/" + filename);
        if (file.exists()) {
            file.delete();
            System.out.println("File deleted: " + filename);
        } else {
            System.out.println("File not found.");
        }
    }
}
