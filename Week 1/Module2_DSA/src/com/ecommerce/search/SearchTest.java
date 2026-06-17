package com.ecommerce.search;

import java.util.Arrays;
import java.util.Comparator;

public class SearchTest {
    public static void main(String[] args) {
        System.out.println("=== Testing E-commerce Search Platform ===\n");


        Product[] inventory = {
            new Product("P104", "Wireless Mouse", "Electronics"),
            new Product("P101", "Gaming Laptop", "Electronics"),
            new Product("P105", "Mechanical Keyboard", "Electronics"),
            new Product("P103", "Noise Cancelling Headphones", "Audio"),
            new Product("P102", "Smartphone Pro", "Electronics")
        };

        String searchTarget = "P103";


        System.out.println("--- Running Linear Search ---");
        long startLinear = System.nanoTime();
        Product linearResult = SearchAlgorithms.linearSearch(inventory, searchTarget);
        long endLinear = System.nanoTime();
        
        System.out.println("Search Target: " + searchTarget);
        System.out.println("Result Found: " + (linearResult != null ? linearResult : "None"));
        System.out.println("Execution Time: " + (endLinear - startLinear) + " ns\n");


        System.out.println("--- Preparing Array for Binary Search ---");
        Arrays.sort(inventory, Comparator.comparing(Product::getProductId));
        System.out.println("Sorted Inventory List:");
        for (Product p : inventory) {
            System.out.println("  " + p);
        }
        System.out.println();

        System.out.println("--- Running Binary Search ---");
        long startBinary = System.nanoTime();
        Product binaryResult = SearchAlgorithms.binarySearch(inventory, searchTarget);
        long endBinary = System.nanoTime();

        System.out.println("Search Target: " + searchTarget);
        System.out.println("Result Found: " + (binaryResult != null ? binaryResult : "None"));
        System.out.println("Execution Time: " + (endBinary - startBinary) + " ns");
    }
}