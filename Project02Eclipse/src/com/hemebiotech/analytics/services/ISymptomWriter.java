package com.hemebiotech.analytics.services;

import java.util.Map;

/**
* Anything that will write symptom data to a file.
* <br><br>
* This interface returns a string containing the path to the output file.
* 
*/
public interface ISymptomWriter {

	/**
	* If no data is available, returns an empty List.
	* @return the path of a file containing symptoms (parsed from a tree map) or null.
	*/
	String WriteSymptoms(Map<String, Integer> symptoms);
}
