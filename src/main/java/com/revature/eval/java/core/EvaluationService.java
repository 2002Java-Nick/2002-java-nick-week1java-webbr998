package com.revature.eval.java.core;

import java.util.regex.Matcher;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Pattern; 
import java.time.temporal.Temporal;
import java.lang.Math;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.*;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		phrase = phrase.toUpperCase();
		
		
		phrase = phrase.replaceAll("[-]", " ");
		
		String[] stringArr = phrase.split(" ");
		int arrLen = stringArr.length;
		String currWord = "";
		
		StringBuffer sb = new StringBuffer();
		String result = "";
		
		for(int i=0; i<arrLen; i++) {
			currWord = stringArr[i];
			sb.append(currWord.charAt(0));
			
		}
		
		result = sb.substring(0);
		return result;
		
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if((sideOne == sideTwo) && sideTwo == sideThree) {
				return true;
			}
			else {
				return false;
			}
		}

		public boolean isIsosceles() {
			if((sideOne == sideTwo || sideOne == sideThree) || sideTwo == sideThree) {
				return true;
			}
			else {
				return false;
			}
		    
		}

		public boolean isScalene() {
			if(((sideOne != sideTwo) && sideTwo != sideThree) && sideOne != sideThree) {
				return true;
			}
			else {
				return false;
			}
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		Hashtable<String, Integer> my_dict = new Hashtable<String, Integer>();
		
		
		my_dict.put("O", 1);
		my_dict.put("B", 3);
		
		my_dict.put("a", 1); 
		my_dict.put("e",1);
		my_dict.put("i", 1);
		my_dict.put("o", 1);
		my_dict.put("u", 1);
		my_dict.put("l", 1);
		my_dict.put("n", 1);
		my_dict.put("r", 1);
		my_dict.put("s", 1);
		my_dict.put("t", 1);
		my_dict.put("d", 2);
		my_dict.put("g", 2);
		my_dict.put("b", 3);
		my_dict.put("c", 3);
		my_dict.put("p", 3);
		my_dict.put("m", 3);
		my_dict.put("f", 4);
		my_dict.put("h", 4);
		my_dict.put("v", 4);
		my_dict.put("w", 4);
		my_dict.put("y", 4);
		my_dict.put("k", 5);
		my_dict.put("j", 8);
		my_dict.put("x", 8);
		my_dict.put("q", 10);
		my_dict.put("z", 10);
		
		int runningSum = 0;
		for(int i=0; i<string.length(); i++){							
			String keyz  = Character.toString(string.charAt(i));
			runningSum += my_dict.get(keyz);
		}
		
		return runningSum;
		
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) throws IllegalArgumentException {
		
		/*
		Pattern patt = Pattern.compile("[\\s]"); 
		  
        // Searching patt in s. 
        Matcher mat = patt.matcher(stringCopy); 
        */
  
        // Replacing 
        System.out.println(string);
        //String regexed = mat.replaceAll(" ", ""); 
		string = string.replaceAll("[- .()]", "");
		
		if(string.length() ==12) {
			throw new IllegalArgumentException();
		}
		
		for(int i=0; i<string.length(); i++) {
			if(!(Character.isDigit(string.charAt(i)))) {
				throw new IllegalArgumentException();
			}
		}
		
		return string;
		
		/*
			String noDots = string.replaceAll(".", "");
			String noDashes = noDots.replaceAll("-", "");
			String noParensOne = noDashes.replaceAll("(", "");
			String noParensTwo = noParensOne.replaceAll(")", "");
			String noPlus = noParensTwo.replaceAll("+", "");
			String noThree = noPlus.replaceAll("   ", "");
			String noWhiteSpace = noThree.replaceAll(" ", "");
			
		
																					
			//String clipped = noWhiteSpace;
			if(noWhiteSpace.charAt(0) == '1') {
				clipped = noDots.substring(1);
			}
			
			if(clipped.length() == 12) {
				throw new IllegalArgumentException();
			}
			*/
			
		
		
		
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		Map< String,Integer> hm = new HashMap< String,Integer>(); 
		
		 if(string == null || string.equals("")) {
	            return hm;
		 }
	     String[] words = string.split("[\\n\\r\\s,]+");
	     
	     for(int i=0; i < words.length; i++ ) {
	    	 String key = words[i];
	    	 
	    	 if(hm.containsKey(key)){
	    		 int tmp = hm.get(key);
	    		 tmp = tmp +1;
	    		 hm.put(key, tmp);
	    	 }
	    	 else {
	    		 hm.put(key, 1);
	    	 }
	    		 	    	 	  	    	 
	     }
	     
	     System.out.println(hm);
	     return hm;
	    	 
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		String stringCopy = string; 
		String currWord ="";
		String storer ="";
		String[] listOfRegularWords = string.split(" ");
		int numberOfWords = listOfRegularWords.length;
		String[] listOfPigLatinWords = new String[numberOfWords];
		
		for(int i=0; i <numberOfWords; i++) {
			currWord = listOfRegularWords[i];
		
			if(currWord.charAt(0) == 'q') {
				String preamble = currWord.substring(0,2);
				String middlePart = currWord.substring(2);
				storer = middlePart + preamble + "ay ";
				listOfPigLatinWords[i] = storer;
			}
			else if(currWord.charAt(0) == 't' && currWord.charAt(1) == 'h') {
				String preamble = currWord.substring(0,2);
				String middlePart = currWord.substring(2);
				storer = middlePart + preamble + "ay ";
				listOfPigLatinWords[i] = storer;
			} 
			else if(currWord.charAt(0) == 's' && currWord.charAt(1) == 'c' && currWord.charAt(2) == 'h') {
				String preamble = currWord.substring(0,3);
				String middlePart = currWord.substring(3);
				storer = middlePart + preamble + "ay ";
				listOfPigLatinWords[i] = storer;
			}
			else if(currWord.charAt(0) == 'a' || currWord.charAt(0) == 'e') {
				storer = currWord + "ay ";
				listOfPigLatinWords[i] = storer;
			}
			else if(currWord.charAt(0) == 'i' || currWord.charAt(0) == 'o' || currWord.charAt(0) == 'u') {
				storer = currWord + "ay ";
				listOfPigLatinWords[i] = storer;
			}
			else {
				String preamble = currWord.substring(0,1);
				String middlePart = currWord.substring(1);
				storer = middlePart + preamble + "ay ";
				listOfPigLatinWords[i] = storer;
			}
			
		}
		
		String result = "";
		
		StringBuffer b = new StringBuffer();
		for(int i=0; i<numberOfWords; i++) {
			b.append(listOfPigLatinWords[i]);
			result = b.toString();
			result = result.trim();
		}
		return result;
		
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		String inputString = Integer.toString(input);
		int magnitude = inputString.length();
		int runningSum =0;
		
		
		for(int i=0; i<magnitude; i++) {
			
			Double doubleNumberToBeMultiplied = new Double(Integer.parseInt(String.valueOf(inputString.charAt(i))));
			Double power = new Double(magnitude);
			Double doubleBeforeConverting = Math.pow(doubleNumberToBeMultiplied, power);
			int tmp = doubleBeforeConverting.intValue();
			runningSum += tmp;
		}
		
		if(runningSum == input) {
			return true;
		}
		else {
			return false;
		}
		
		
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		int lIntRep = (int) l;
		int upperBounds = lIntRep;
		
		
		List<Long> arlist = new ArrayList<Long>();
		Long longRepresentation = new Long("0");
		
		
		for(int i=2; i<=upperBounds; i++) {		
			while(upperBounds%i ==0) {
				longRepresentation = Long.parseLong(Integer.toString(i));
				arlist.add(longRepresentation);
				upperBounds /= i;
			}																				
		}
		
		return arlist;
									
		
		/*
		
		boolean[] array = new boolean[size];
		for(int i=0; i< size; i++) {
			array[i] = false;
		}
		
		for(int j=2; j<size; j++) {
			if(size % j == 0) {
				for(int k=j; k<size; k+=j ) {
					array[k] = true; 
				}
			}
		}
		
		
		Long element;
		for(int i=2; i<size; i++) {
			if(array[i] == true) {
				Integer intObj = new Integer(i);
				element = intObj.longValue(); 
				arlist.add(element);
			}
		}
		
		
		return arlist;
		*/
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;
		
		public RotationalCipher(int key) {
			super();
			this.key = key;
		}
		
		public static int getKey() {
			return this.key;
		}

		public String rotate(String string) {
			
			
			int stringLen = string.length();
			boolean uppercase = false;
			String alphabet = "abcdefghijklmnopqrstuvwxzy";
			StringBuffer sb = new StringBuffer();
			
			for(int i=0; i<stringLen; i++) {										
					int equation = (i + key) % 26;								
					sb.append(alphabet.charAt(equation));
				
			}
			
			String messedUpAlphabet = sb.toString();
			StringBuffer result = new StringBuffer();
			
			for(int i=0; i<stringLen; i++) {
													
				if(Character.isUpperCase(string.charAt(i))) {
					uppercase = true;					
				}
				if(!Character.isAlphabetic(string.charAt(i))) {					
					result.append(string.charAt(i));
				}
				else {
					if(!uppercase) {											
						result.append(messedUpAlphabet.charAt(alphabet.indexOf(string.charAt(i))));
					}
					
					else {
					
						result.append(Character.toUpperCase(messedUpAlphabet.charAt(alphabet.indexOf(Character.toLowerCase(string.charAt(i))))));
						uppercase = false;
						
						
					}
				}
													
			}
			
			
			return result.toString();					
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		
		/*
		int countDown = i;
		
		while(countDown > 0) {
			
		}
		
		
		
		
		
		int num = 1;
		int count =0;
		int j;
		 
	    while (count < i){
	      num=num+1;
	      for (j = 2; j <= num; j++){
	        if (num % j == 0) {
	          break;
	        }
	      }
	      if ( j == num){
	        count = count+1;
	      }
	    }
	    
	    return num;
		*/
		
		
		
		
		
		
		
		/*
		
		int countOfCurrPrimes = 0;
		
		
		
		//convert from int to long.
		String iS = Integer.toString(i);
		Long l = new Long(iS); 
		ArrayList myList = (ArrayList)calculatePrimeFactorsOf(l);
		
		
		myList.get(i-1);
		
		
		
		
		
		
		
		
		
		int countOfPrimes = 0;
		int num=1;
		if(i<2) {
			throw new IllegalArgumentException("i must be 2 or greater ");
		}
		else {
			while(countOfPrimes < i) {
				num = num +1;
				int jcopy=2;
				for(int j=2; j<= num; j++) {
					if(num % j == 0) {
						jcopy=j;
						break;
					}
					jcopy=j;
				}
				if(jcopy == num) {
					countOfPrimes++;
				}
			}
			return num;
		}
		*/
		
		
		
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			
			String alphabet = "abcdefghijklmnopqrstuvwxyz";
			String reverse =  "zyxwvutsrqponmlkjihgfedcba";
			
			StringBuffer sb = new StringBuffer();
			
			for(int i=0; i<string.length(); i++) {
				sb.append(reverse.charAt(alphabet.indexOf(string.charAt(i))));
			}
					
		
					
		
			return sb.toString();
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			string = string.replaceAll(" ", "");
			String alphabet = "abcdefghijklmnopqrstuvwxyz";
			String reverse =  "zyxwvutsrqponmlkjihgfedcba";
			
			StringBuffer sb = new StringBuffer();
			
			for(int i=0; i<string.length(); i++) {
				sb.append(alphabet.charAt(reverse.indexOf(string.charAt(i))));
			}
					
		
					
		
			return sb.toString();
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		string = string.replaceAll("-", "");
		string = string.replaceAll(" ", "");
		int firstMultiply =0;
		int runningSum=0;
		
		if(string.charAt(9) == 'X') {
			string = string.replaceAll("X", "10");
		}
		int multiplicand = 10;
		int value =0;
		
		
		for(int i=0; i<9; i++) {
			char tmp = string.charAt(i);
			if(Character.isLetter(tmp)) {
				return false;
			}
		}
		
		
		for(int i =0; i<9; i++) {
			value = Integer.parseInt(String.valueOf(string.charAt(i)));
			firstMultiply = (multiplicand * value);
			runningSum += firstMultiply;
			multiplicand --;
		}
		
		if(string.charAt(9) == '1' && string.charAt(10) == '0') {
			runningSum += 10;
			if((runningSum % 11) == 0) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (Character.isLetter(string.charAt(9))) {
			return false;
		}
		else {
			int temp = Integer.parseInt(String.valueOf(string.charAt(9)));			
			runningSum += temp;
			if(runningSum % 11 == 0) {
				return true;
			}
			else {
				return false;
			}
		}
		
		
		
		
		
		
		
		
																			
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		
		string = string.toLowerCase();
		String a = Character.toString('a');
		String b = Character.toString('b');
		String c = Character.toString('c');
		String d = Character.toString('d');
		String e = Character.toString('e');
		String f = Character.toString('f');
		String g = Character.toString('g');
		String h = Character.toString('h');
		String i = Character.toString('i');
		String j = Character.toString('j');
		String k = Character.toString('k');
		String l = Character.toString('l');
		String m = Character.toString('m');
		String n = Character.toString('n');
		String o = Character.toString('o');
		String p = Character.toString('p');
		String q = Character.toString('q');
		String r = Character.toString('r');
		String s = Character.toString('s');
		String t = Character.toString('t');
		String u = Character.toString('u');
		String v = Character.toString('v');
		String w = Character.toString('w');
		String x = Character.toString('x');
		String y = Character.toString('y');
		String z = Character.toString('z');
		if(string.contains(a) && string.contains(b) && string.contains(c)  && string.contains(d) && string.contains(e) && string.contains(f) && string.contains(g) && string.contains(h) && string.contains(i) && string.contains(j) && string.contains(k) && string.contains(l) && string.contains(m) && string.contains(n) && string.contains(o) && string.contains(p) && string.contains(q) && string.contains(r) && string.contains(s) && string.contains(t) && string.contains(u) && string.contains(v) && string.contains(w) && string.contains(x) && string.contains(y) && string.contains(z)  ) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		
		LocalDateTime rightNow = LocalDateTime.now();
		LocalDate rn = LocalDate.now();
		
		int gigaSecond = 1000000000;
		long lngGigaSecond =(long)gigaSecond;
		if(given.getClass().equals(LocalDateTime.class)) {
			rightNow = (LocalDateTime) given;
			return rightNow.plusSeconds(lngGigaSecond);
		}
		
		else {
			rn = (LocalDate) given;
			
			rightNow = rn.atStartOfDay();
			
			return rightNow.plusSeconds(lngGigaSecond);
		}
		
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		
		ArrayList<Integer> myList = new ArrayList<Integer>(i);
		
		
		
		int j= 1;
		
		while(j<i){
			for(int x : set ) {
				Integer intObjCopy = new Integer(j);
				if(j % x == 0 && !myList.contains(intObjCopy)) {
					Integer intObj = new Integer(j);
					myList.add(intObj);
				}
			}
			j++;
		}
		Object [] intRepresentationOfMyList = myList.toArray();
		
		int myListLen = intRepresentationOfMyList.length;
		int[] resArray = new int[myListLen];
		
		for(int y=0; y<myListLen; y++) {
			resArray[y] =0;
		}
		
		
		int runningSum =0;
		String intermediateRepresentation = "";
		for(int y=0; y<myListLen; y++) {
			 intermediateRepresentation = intRepresentationOfMyList[y].toString();
			 int result = Integer.parseInt(intermediateRepresentation);
			 resArray[y] = result;
		}
		
		for(int y=0; y<myListLen; y++) {
			runningSum += resArray[y];
		}
		
		
		
		
		
		
		return runningSum;
	}

	/**'0
	 +* 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		string = string.replaceAll("[ ]", "");
		int tmp =0;
		int[] sumArray = new int[string.length()];
		int runningSum =0;
		for(int i=0; i < string.length(); i++) {
			if(!(Character.isDigit(string.charAt(i)))) {
				return false;
			}
			
			else {							
				if(i%2==1) {
					int a = Integer.parseInt(String.valueOf(string.charAt(i)));
					a = a * 2;
					if(a>9) {
						a = a-9;
					}
					sumArray[i] =a;
				}
				else {
					int a = Integer.parseInt(String.valueOf(string.charAt(i)));
					sumArray[i] = a;
				}
				
				
			}
		}
		
		for(int i=0; i<string.length(); i++) {
			runningSum += sumArray[i];
		}
		
		if((runningSum %10) ==0 ) {
			return true;
		}
		else {
			return false;
		}
		
		
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		string = string.replace("?", "");
		if(string.contains("plus")) {
			String[] parts = string.split(" ");
			int firstNum = Integer.parseInt(parts[2]);
			int secondNum =Integer.parseInt(parts[4]);
			
			return firstNum + secondNum;
		}
		else if(string.contains("minus")) {
			String[] parts = string.split(" ");
			int firstNum = Integer.parseInt(parts[2]);
			int secondNum =Integer.parseInt(parts[4]);
			
			return firstNum - secondNum;
		}
		else if (string.contains("multiplied")) {
			String[] parts = string.split(" ");
			int firstNum = Integer.parseInt(parts[2]);
			int secondNum =Integer.parseInt(parts[5]);
			
			return firstNum * secondNum;
		}
		else if (string.contains("divided")) {
			String[] parts = string.split(" ");
			int firstNum = Integer.parseInt(parts[2]);
			
			int secondNumLen = parts[5].length();
			int secondNum =Integer.parseInt(parts[5]);
			
			if(secondNum ==0) {
				return -1;
			}
			
			
			return firstNum / secondNum;
		}
		
		return 0;
	}

}
