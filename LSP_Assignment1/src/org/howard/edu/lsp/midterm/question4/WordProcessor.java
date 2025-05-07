package org.howard.edu.lsp.midterm.question4;

import java.util.*;
import java.util.Map;

public class WordProcessor {
		
	    private String sentence; // Stores the sentence to be processed
	    private int maxWordlength;
	    private String[] sentenceWords;
	    private Map<String, Integer> wordMap;
	    private List<String> longestWords;

	    // Constructor
	    /**
	     * This creates the instance, it is given a sentence and immediatly stoies the og sentence and the words of the sentence
	     * it also calls upon another method that anylazes the given sentence
	     * @param sentence - full sentence given
	     */
	    public WordProcessor(String sentence) { 
	    	this.sentence = sentence;
	    	this.sentenceWords = sentence.split("\\s+");
	    	this.wordMap = new HashMap<>(); // Initialize wordMap
	    	this.longestWords = new ArrayList<>(); // Initialize longestWords

	    	this.wordAnalyzer();
	    }
	    
	    
	    /**
	     * This class is only called in the intilizer, it goes through noting the length of each word in a map for all the words
	     */
	    private void wordAnalyzer() {
	    	for (String word : this.sentenceWords) {
	    		this.wordMap.put(word, word.length());
	    		if (word.length() > maxWordlength) {
	    			maxWordlength = word.length();
	    		}}}
	 

	    /**
	     * this method iterates through the map made upon creation of the instance. if the length is the same as the longest length it puts them in the longest word list 
	     * @return lonestWords is the list of the sentences longest words to be  returned in order
	     */
	    // Method to find all longest words in the sentence
	    public List<String> findLongestWords(){
	    	for (String word: this.sentenceWords){
	    		if (wordMap.get(word).equals(maxWordlength)) {
	    			longestWords.add(word);
	    		}
	    	}
	    	return longestWords;
	    	
	    }
	}


