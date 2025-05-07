package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;


public class VotingMachine {
	
	private HashMap<String, Integer> candidateList = new HashMap();
	private String winningCandidate;
	private int winningVotes;
	
	
	public void addCandiate(String candidate) {
		candidateList.put(candidate, 0);
	}
	
	/**
	 * This method allows users to cast a vote,
	 * it takes in the candidate name and accesses the candidate list 
	 *  
	 * @param candidate  it is a string with candidate name
	 */
	public boolean castVote(String candidate) {
	
		if (candidateList.containsKey(candidate)){
			candidateList.put(candidate, candidateList.get(candidate)+1);
			return true;
		}
		else {
			return false;
			
		}
	}

	/**
	 * This iterates through the entries, the person with the most winning votes first wins
	 * I got the for loop for highest vote from chatgpt to quickly get the syntax correct.
	 * 
	 * @return it returns the key which is the winning candidate name
	 */
	public String getWinner() {
		for (HashMap.Entry<String, Integer> entry : candidateList.entrySet()) {
            if (entry.getValue() > winningVotes) {
            	winningVotes = entry.getValue();
            	winningCandidate = entry.getKey();
            }
        }
	return winningCandidate;
	}
}
