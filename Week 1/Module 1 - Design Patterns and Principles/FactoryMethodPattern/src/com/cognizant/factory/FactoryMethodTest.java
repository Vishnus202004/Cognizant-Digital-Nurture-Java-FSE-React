package com.cognizant.factory;

public class FactoryMethodTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Factory Method Pattern Implementation ===\n");

        DocumentFactory wordFactory = new WordFactory();
        Document myDoc1 = wordFactory.createDocument();
        myDoc1.open();
        myDoc1.close();

        System.out.println("----------------------------------");

        DocumentFactory pdfFactory = new PdfFactory();
        Document myDoc2 = pdfFactory.createDocument();
        myDoc2.open();
        myDoc2.close();

        System.out.println("----------------------------------");

        
        DocumentFactory excelFactory = new ExcelFactory();
        Document myDoc3 = excelFactory.createDocument();
        myDoc3.open();
        myDoc3.close();
    }
}