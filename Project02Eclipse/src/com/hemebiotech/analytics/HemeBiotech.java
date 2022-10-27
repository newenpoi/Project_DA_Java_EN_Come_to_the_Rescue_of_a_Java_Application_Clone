package com.hemebiotech.analytics;

import java.io.FileInputStream;
import java.util.Properties;

import com.hemebiotech.analytics.classes.AnalyticsCounter;

/**
* Represents the entry point of the application.
*/
public class HemeBiotech {
    
    // Constants declarations.
    private static final String config = "HemeBiotech.properties";
    
    public static void main(String args[]) throws Exception {
        
        // Loads application properties.
        Properties properties = new Properties();
        properties.load(new FileInputStream(config));
        
        // Creates new instance of this application.
        AnalyticsCounter ac = new AnalyticsCounter(properties.getProperty("input"), properties.getProperty("output"));
        ac.run();
    }
}
