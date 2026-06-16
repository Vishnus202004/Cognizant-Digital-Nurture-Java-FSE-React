package com.cognizant.factory;

public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Microsoft Word Document (.docx)...");
    }

    @Override
    public void close() {
        System.out.println("Saving and closing Word Document.");
    }
}