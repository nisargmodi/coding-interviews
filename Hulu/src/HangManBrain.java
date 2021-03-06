import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Iterator;

public class HangManBrain {

	private Map<Integer, List<String>> wordList = new HashMap<Integer, List<String>>();
	private Set<Character> correctGuessSet = new HashSet<Character>();
	private Set<Character> incorrectGuessSet = new HashSet<Character>();
	
	HangManBrain() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("dictionary.txt")));
			for (String str; (str = reader.readLine()) != null;) {
				str = str.trim();
				if (!wordList.containsKey(str.length())) {
					wordList.put(str.length(), new ArrayList<String>());
				}
				wordList.get(str.length()).add(str);
			}
		} catch (IOException e) {
			System.err.println(e);
		}

	}

	// make a guess based on the state
	public char makeGuess(String state) {
		List<String> state_list = new ArrayList<String>(Arrays.asList(state
				.split("[^A-Z_']+")));
		StringBuilder excluding = new StringBuilder(); //StringBuilder better and efficient than string for appending  
		for (Iterator<Character> ex = incorrectGuessSet.iterator(); ex.hasNext();) {
			excluding.append(ex.next());
		}
		List<String> possibleWords = new ArrayList<String>();
		
		String wordToBeGuessed = getMinUnderscoreWord(state_list);
		
		//if the length is 1, then most likely letters are 'a' and 'i'
		if(wordToBeGuessed.length() == 1){
			return (!correctGuessSet.contains('a') && !incorrectGuessSet.contains('a')) ? 'a' : 'I';
		}
		//guessing the one with least number of '_'
		String word = wordToBeGuessed.toLowerCase();
		Pattern regex = Pattern.compile(word.replace(
				"_",
				(excluding.length() > 0) ? String.format("[a-z&&[^%s]]",
						excluding) : "[a-z]"));
		if (wordList.containsKey(word.length())) {
			for (String guess : wordList.get(word.length())) {
				Matcher match = regex.matcher(guess);
				if (match.find()) {
					possibleWords.add(guess); // get a list of words that match the state
				}
			}
		}
		//count the frequency of each letter within the possible words
		Map<Character, Integer> frequency = new HashMap<Character, Integer>();
		for (String possible : possibleWords) {
			Set<String> letters = new HashSet<String>();
			for (char letter : possible.toCharArray()) {
				if (!letters.contains(letter)) {
					if (!frequency.containsKey(letter)) {
						frequency.put(letter, 1);
					} else {
						frequency.put(letter, frequency.get(letter) + 1);
					}
				}
			}
		}
		//find the letter with highest frequency
		char guessLetter = 'a';
		int freq = 0;
		boolean no_letter = true;
		for (char c = 'a'; c <= 'z'; c++) {
			if (!correctGuessSet.contains(c) && !incorrectGuessSet.contains(c)) {
				if (frequency.get(c) != null && frequency.get(c) > freq) {
					guessLetter = c;
					freq = frequency.get(c);
					no_letter = false;
				}
			}
		}
		//when there's no letter left possible to guess
		if (no_letter) {
			for (char c = 'a'; c <= 'z'; ++c) {
				if (!(correctGuessSet.contains(c) || incorrectGuessSet.contains(c))) {
					return c;
				}
			}
		}
		return guessLetter;
	}

	// put the guessed letters into appropriate group
	public void update(char guess, boolean success) {
		if (success) {
			correctGuessSet.add(guess);
		} else {
			incorrectGuessSet.add(guess);
		}
	}
	
	public static String getMinUnderscoreWord(List<String> state_list) {
		
		
		int count = 0;
		int min = 100;
		String wordToBeProcessed = null;
		for(String s: state_list) {
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i) == '_') count ++;
			}
			
			if(count == 0) continue;
			
			if(count<min) {
				min = count;
				wordToBeProcessed = s;
			}
			
			if(count == min) {
				if(wordToBeProcessed.length()<s.length())
					wordToBeProcessed = s;
			}
			
			count = 0 ;
		}
		
		System.out.println(wordToBeProcessed);
		return wordToBeProcessed;
		
	}
}