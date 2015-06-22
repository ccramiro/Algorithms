package core;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

public class StringManipulation {

	// Private constructor - best way to avoid instantiation
	// Class is final as side effect
	private StringManipulation( ) { }

	public static boolean getPalindrome( String iWord ){

		List<Character> lPalindrome = new LinkedList<>(); // ArrayList can also be used here
		for ( char lCh : iWord.toCharArray() ){
			lPalindrome.add( lCh );
		}

		ListIterator<Character> lIterator = lPalindrome.listIterator();
		ListIterator<Character> lRevIterator = lPalindrome.listIterator( lPalindrome.size() );

		while ( lIterator.hasNext() && lRevIterator.hasPrevious() ){
			if ( lIterator.next() != lRevIterator.previous() ){
				return false;
			}
		}
		return true;
	}

	public static Set<String> removeDuplicateWords( String iSentence ){
		Set<String> lWords = new HashSet<>();
		for ( String lWord : iSentence.split("\\W+") ) {
			lWords.add( lWord );
		}
		return lWords;
	}

	public static Set<Character> getUsedLetters( String iSentence ){
		Set<Character> iLetters = new TreeSet<>();
		for ( char iLetter : iSentence.toCharArray() ) {
			iLetters.add( iLetter );
		}
		return iLetters;
	}

}
