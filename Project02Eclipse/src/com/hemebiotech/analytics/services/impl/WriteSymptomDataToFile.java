package com.hemebiotech.analytics.services.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import com.hemebiotech.analytics.services.ISymptomWriter;

public class WriteSymptomDataToFile implements ISymptomWriter {
    
	private String filepath;
	
	/**
	* @param filepath a full or partial path to the file that will be written.
	*/
	public WriteSymptomDataToFile (String filepath) {
		this.filepath = filepath;
	}
    
    @Override
	public String WriteSymptoms(Map<String, Integer> symptoms) {
        
	    try {
            BufferedWriter buffer = new BufferedWriter(new FileWriter(filepath));
            
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                
				// Format and writes a new line using key and value of map.
				String line = String.format("%s : %d%n", entry.getKey(), entry.getValue());
                buffer.write(line);
            }
            
            buffer.close();

			// Returns the output path as a string.
			Path file = Paths.get(filepath);
			return file.toString();
        }
        catch (IOException e) {
            // With the last formatting pattern (%n) always outputs the correct platform-specific line separator.
            System.err.format("Failed to write to file : %s.%n", filepath);
        }
        
		return null;
	}
    
}
