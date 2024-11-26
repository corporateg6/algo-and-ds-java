/*
 * Brently George
 */

//A String object that automatically calculates the number of substring occurrences
//the substring we are looking for will be "STRING_TO_MATCH"

//TODO maybe add some more comments?
public class MatchString implements Comparable<MatchString> {
	private String stringData;
	private int numOfMatches;
	public static final String STRING_TO_MATCH = "default";
	public static final String DEFAULT_STRING = "Default String";
	
	public MatchString() {
		this.stringData = DEFAULT_STRING;
		this.numOfMatches = this.countMatches(DEFAULT_STRING, STRING_TO_MATCH);
	}
	
	public MatchString(String stringData) {
		this.setStringData(stringData);
		this.setNumOfMatches(stringData, STRING_TO_MATCH);
	}
	
	public MatchString(String stringData, String matchWith) {
		this.setStringData(stringData);
		this.setNumOfMatches(stringData, matchWith);
	}
	
	public void setStringData(String stringData) {
		if (stringData != null) {
			this.stringData = stringData;
		} else {
			this.stringData = DEFAULT_STRING;
		}
	}
	
	public String getStringData() {
		return this.stringData;
	}
	
	public void setNumOfMatches(String stringData, String matchWith) {
		if (matchWith == null)
			matchWith = STRING_TO_MATCH;
		if (stringData != null) {
			this.numOfMatches = this.countMatches(stringData, matchWith);
		} else {
			this.numOfMatches = this.countMatches(DEFAULT_STRING, matchWith);
		}
	}
	
	public int getNumOfMatches() {
		return this.numOfMatches;
	}
	
	public String toString() {
		//this one was for debugging, leaving for now in case we want to debug more later
		//return "String: " + this.stringData + " Matches: " + this.numOfMatches;
		return this.stringData;
	}
	
	//count the number of times the pattern shows up in the stringData and return that as an integer.
	//in theory we could move this algorithm outside of this and have it accept Strings as parameters, but I wanted to try this out.
	//it works, but logically it might not make sense to create this custom class just for this.
	//more than one way to do things though right?
	private int countMatches(String stringData, String pattern) {
		if (pattern == null || pattern.length() < 1) {
			return 0;  //return 0 if our pattern doesn't exist or is something like "";
		}
		int count = 0;
		int matchTracker = 0;
		int backTracker = 0; //in case we start matching and fail, we need to restart our search here.
		//for example, if we are trying to count ssort, we don't want to fail on the second s and then start checking again at o
		//or if we are trying to check sosort, same situation as above we need to start checking again at the place we started checking plus 1.
		for (int i=0; i<stringData.length(); i++) {
			if (stringData.toLowerCase().charAt(i) == pattern.toLowerCase().charAt(matchTracker)) {
				if (matchTracker == 0)
					backTracker = i;
				matchTracker++;
				if(matchTracker == pattern.length()) {
					matchTracker = 0;
					count ++;
				}
			} else {
				if (matchTracker > 0) {
					matchTracker = 0; //in case match tracker got incremented previously
					i = backTracker;
				}
			}
		}
		return count;
	}
	
	//comparing based on how many matches to the supplied string to match we have counted.
	//in this implementation the string being matched could in theory be different, as we calculate the
	//number of matches at the time of instantiation based on what the user has supplied as the string to match.
	//up to the implementer to keep track of this.
	public int compareTo(MatchString aMS) {
		if(aMS == null)
			return -1;
		if(this.getNumOfMatches() < aMS.getNumOfMatches())
			return -1;
		else if(this.getNumOfMatches() > aMS.getNumOfMatches())
			return 1;
		else
			return this.getStringData().compareTo(aMS.getStringData());
	}
	
}
