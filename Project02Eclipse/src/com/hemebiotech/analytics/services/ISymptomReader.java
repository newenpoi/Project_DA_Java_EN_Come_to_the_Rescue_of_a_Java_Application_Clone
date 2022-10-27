package com.hemebiotech.analytics.services;

import java.util.Map;

/**
* Anything that will read symptom data from a source.
* <br><br>
* This version returns a tree map containing the symptom as a key and occurence as value.
* <br><br>
* Tree map automatically order keys and can take a custom comparator.
* 
*/
public interface ISymptomReader {
	
	/**
	* If no data is available, returns an empty List.
	* @return a tree map of symptoms as key and occurence as value.
	*/
    Map<String, Integer> GetSymptoms();
	
}
