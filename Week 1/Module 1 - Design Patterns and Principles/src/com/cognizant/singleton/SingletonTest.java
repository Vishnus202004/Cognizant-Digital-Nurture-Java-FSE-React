package com.cognizant.singleton;


public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Singleton Pattern Implementation ===\n");

       
        Logger logger1 = Logger.getInstance();
        
       
        Logger logger2 = Logger.getInstance();

      
        logger1.log("User 'Admin' logged into the system.");
        logger2.log("Database query executed successfully.");

        System.out.println("\n--- Verification Result ---");
        
  
        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both logger1 and logger2 point to the IDENTICAL instance.");
            System.out.println("Logger 1 Memory Address Hashcode: " + logger1.hashCode());
            System.out.println("Logger 2 Memory Address Hashcode: " + logger2.hashCode());
        } else {
            System.out.println("FAILURE: Discrepancy detected! Multiple instances of the logger exist.");
        }
    }
}