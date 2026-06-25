package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        System.out.println("=== Initializing Spring IoC Container ===");
        

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println("=== Spring Context Loaded Successfully ===");

       
        BookService bookService = context.getBean("bookService", BookService.class);

       
        bookService.registerNewBook("Effective Java (3rd Edition)");

        System.out.println("=== Execution Complete ===");
    }
}