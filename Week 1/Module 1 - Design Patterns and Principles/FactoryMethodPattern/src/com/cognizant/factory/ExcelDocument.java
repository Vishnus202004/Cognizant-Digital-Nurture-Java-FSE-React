package com.cognizant.factory;

public class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel Spreadsheet (.xlsx) and calculating formulas...");
    }

    @Override
    public void close() {
        System.out.println("Saving spreadsheets and closing Excel.");
    }
}