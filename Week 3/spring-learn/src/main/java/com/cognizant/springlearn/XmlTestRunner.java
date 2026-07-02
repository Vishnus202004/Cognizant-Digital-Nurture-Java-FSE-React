package com.cognizant.springlearn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cognizant.springlearn.model.Country;

public class XmlTestRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(XmlTestRunner.class);

    public static void main(String[] args) {
        LOGGER.info("--- Starting Standalone XML Bean Test Configuration ---");
        displayDate();
        displayCountry();
        displayCountries();
    }

    public static void displayDate() {
        LOGGER.info("START: displayDate()");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        try {
            Date targetDate = format.parse("31/12/2018");
            System.out.println("-> Parsed Date: " + targetDate);
        } catch (Exception e) {
            LOGGER.error("Error parsing date: ", e);
        }
        LOGGER.info("END: displayDate()");
    }

    public static void displayCountry() {
        LOGGER.info("START: displayCountry()");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("in", Country.class);
        System.out.println("-> Loaded Country: " + country.getCode() + " - " + country.getName());
        LOGGER.info("END: displayCountry()");
    }

    @SuppressWarnings("unchecked")
    public static void displayCountries() {
        LOGGER.info("START: displayCountries()");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countries = context.getBean("countryList", List.class);
        System.out.println("-> All Loaded Countries:");
        for (Country country : countries) {
            System.out.println("   [" + country.getCode() + "] " + country.getName());
        }
        LOGGER.info("END: displayCountries()");
    }
}
