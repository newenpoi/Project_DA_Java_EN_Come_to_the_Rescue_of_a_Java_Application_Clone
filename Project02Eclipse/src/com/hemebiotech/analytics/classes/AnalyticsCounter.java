package com.hemebiotech.analytics.classes;

import java.util.Map;

import com.hemebiotech.analytics.services.ISymptomReader;
import com.hemebiotech.analytics.services.ISymptomWriter;
import com.hemebiotech.analytics.services.impl.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.services.impl.WriteSymptomDataToFile;

/**
* Represents the main building block of Analytics Counter application.
*/
public class AnalyticsCounter {
	
	// Inteface for reading from file.
	private final ISymptomReader reader;

	// Interface for writing to file.
	private final ISymptomWriter writer;
	
	/**
	* 
	* @param input The symptoms files to read.
	* @param output The path to the generated output.
	*/
	public AnalyticsCounter(String input, String output) {
		
		this.reader = new ReadSymptomDataFromFile(input);
		this.writer = new WriteSymptomDataToFile(output);
	}

	public void run() {
	    // Retrieves a hash map of symptoms within a file containing the symptom as key and occurence as value.
	    Map<String, Integer> symptoms = reader.GetSymptoms();
	    
	    // Writes symptom to file.
	    String path = writer.WriteSymptoms(symptoms);
	    
		// If the path returned is not empty we can safely assume the file has been written.
		if (path.isEmpty() == false) System.out.printf("Symptoms file saved as %s.%n", path);
	}

}
