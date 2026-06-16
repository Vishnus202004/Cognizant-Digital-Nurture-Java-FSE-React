package com.cognizant.factory;

public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Adobe PDF Document (.pdf) in Read-Only mode...");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF Document viewer.");
    }
}