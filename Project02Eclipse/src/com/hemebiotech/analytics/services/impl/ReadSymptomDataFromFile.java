package com.hemebiotech.analytics.services.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import com.hemebiotech.analytics.services.ISymptomReader;

public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	* @param filepath a full or partial path to file with symptom strings in it, one per line.
	*/
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public Map<String, Integer> GetSymptoms() {
		/*
			Declares a new tree map using string as key and integer as value.
			String implements the Comparable interface, which makes TreeMap suitable.
		*/
	    Map<String, Integer> result = new TreeMap<String, Integer>();
		
		try {
			System.out.printf("Reading symptoms file : %s.%n", filepath);
			
			BufferedReader reader = new BufferedReader (new FileReader(filepath));
			String line = reader.readLine();
			
			while (line != null) {
			    
				// Reads this line and use the symptom as a key.
				// Uses 1 as default value if this key has not been mapped yet otherwise increments it.
				result.put(line, result.getOrDefault(line, 0) + 1);
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			System.err.format("Failed to read the file : %s.%nShutting down application.%n", filepath);
			System.exit(1);
		}
		
		return result;
	}
	
}
