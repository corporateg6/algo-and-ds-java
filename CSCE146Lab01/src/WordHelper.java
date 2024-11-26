/*
 * Brently George
 */
public class WordHelper {

	public static final String VOWELS = "aeiouy";
	public static final String CONSONANTS = "bcdfghjklmnpqrstvwxz";
	
	//copy then sort the copied array of strings by the number of vowels, smallest to largest
	public static String[] sortByVowels(String[] inputStringArray) {
		
		//create a new array to copy the contents of the input array
		String[] stringArray = copyStringArray(inputStringArray);
		
		//bubble sort with vowel count method
		boolean hasSwapped = true;
		while(hasSwapped) {
			hasSwapped = false;
			for(int i=0;i<stringArray.length-1;i++) {
				if(countVowels(stringArray[i]) > countVowels(stringArray[i+1])) {
					//Swap
					String temp = stringArray[i];
					stringArray[i] = stringArray[i+1];
					stringArray[i+1] = temp;
					hasSwapped = true;
				}
			}
		}
		
		return stringArray;
	}
	
	//copy then sort the copied array of strings by the number of consonants, smallest to largest
	public static String[] sortByConsonants(String[] inputStringArray) {
		
		//create a new array to copy the contents of the input array
		String[] stringArray = copyStringArray(inputStringArray);
		
		//bubble sort with consonant count method
		boolean hasSwapped = true;
		while(hasSwapped) {
			hasSwapped = false;
			for(int i=0;i<stringArray.length-1;i++) {
				if(countConsonants(stringArray[i]) > countConsonants(stringArray[i+1])) {
					//Swap
					String temp = stringArray[i];
					stringArray[i] = stringArray[i+1];
					stringArray[i+1] = temp;
					hasSwapped = true;
				}
			}
		}
		
		return stringArray;
	}
	
	//copy then sort the copied array of strings by string length, smallest to largest
	public static String[] sortByLength(String[] inputStringArray) {
		
		//create a new array to copy the contents of the input array
		String[] stringArray = copyStringArray(inputStringArray);

		//bubble sort with string length
		boolean hasSwapped = true;
		while(hasSwapped) {
			hasSwapped = false;
			for(int i=0;i<stringArray.length-1;i++) {
				if(stringArray[i].length() > stringArray[i+1].length()) {
					//Swap
					String temp = stringArray[i];
					stringArray[i] = stringArray[i+1];
					stringArray[i+1] = temp;
					hasSwapped = true;
				}
			}
		}
		
		return stringArray;
	}
	
	//method to count vowels
	public static int countVowels(String inputStr) {
		//iterate through each character in the string and compare with the vowels
		//if that character is a vowel, keep a running count.
		//return that count
		int subtotal = 0;
		for (int i=0; i<inputStr.length(); i++) {
			if (VOWELS.contains(String.valueOf(inputStr.toLowerCase().charAt(i))))
				subtotal += 1;
		}
		return subtotal;
	}
	//method to count consonants
	public static int countConsonants(String inputStr) {
		//iterate through each character in the string and compare with the consonants
		//if that character is a consonant, keep a running count.
		//return that count
		int subtotal = 0;
		for (int i=0; i<inputStr.length(); i++) {
			if (CONSONANTS.contains(String.valueOf(inputStr.toLowerCase().charAt(i))))
				subtotal += 1;
		}
		return subtotal;
	}
	
	//Creating my own method to copy an array instead of using built in method for fun.
	public static String[] copyStringArray(String[] inputStringArray) {
		//container to hold copy of array
		String[] outputStringArray = new String[inputStringArray.length];
		//loop through input array and copy each value into the new array.
		for (int i=0; i<inputStringArray.length; i++){
			outputStringArray[i] = inputStringArray[i];
		}
		//return reference to the array.
		return outputStringArray;
	}
}
