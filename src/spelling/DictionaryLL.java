package spelling;

import java.util.LinkedList;

/**
 * A class that implements the Dictionary interface using a LinkedList
 *
 */
public class DictionaryLL implements Dictionary {

	private LinkedList<String> myDict;

	// Add a constructor
	public DictionaryLL() {
		myDict = new LinkedList<>();
	}

	/**
	 * Add this word to the myDictionary. Convert it to lowercase first for the
	 * assignment requirements.
	 * 
	 * @param word
	 *            The word to add
	 * @return true if the word was added to the myDictionary (it wasn't already
	 *         there).
	 */
	public boolean addWord(String word) {
		// Implement this method
		return isWord(word) ? false : myDict.add(word.toLowerCase());
	}

	/** Return the number of words in the myDictionary */
	public int size() {
		// Implement this method
		return myDict.size();
	}

	/** Is this a word according to this myDictionary? */
	public boolean isWord(String s) {
		// Implement this method
		return myDict.contains(s.toLowerCase());
	}

}