package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Controller for Inventory Management.
 * 
 * // TODO: Check Linear ticket LIN-102 for the updated stock levels logic
 */
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);

    @GetMapping("/status/{itemCode}")
    public String checkInventory(@PathVariable String itemCode) {
        logger.info("Checking inventory for item code: {}", itemCode);

        // BAD PRACTICE: Empty catch block (Triggers SonarQube Code Smell)
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }

        // VULNERABILITY: Intentional IndexOutOfBoundsException (Triggers Sentry & Slack)
        List<String> inventoryList = Arrays.asList("ItemA", "ItemB");
        // This will throw an exception if the user tries to access anything beyond index 1
        String currentItem = inventoryList.get(5); 

        return "Inventory status retrieved for: " + currentItem;
    }
}
