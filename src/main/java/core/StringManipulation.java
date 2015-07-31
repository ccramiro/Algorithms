package core;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class StringManipulation {

	// Private constructor - best way to avoid instantiation
	// Class is final as side effect
	private StringManipulation( ) { }

	public static String collapseSpaces( String iInputText ){
		return iInputText.replaceAll( "\\s+", " " );
	}

	public static String removeInbetweenSpace( String iInputTest ){
		String lPattern = "(\\w)(\\s+)([\\.,])";
		return iInputTest.replaceAll( lPattern, "$1$3" );
	}

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

	public static boolean validateIPV4( String iIPStr ){
		String lRegexIPV4 = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
		return Pattern.matches( lRegexIPV4, iIPStr);
	}

	public static boolean validateIPV6( String iIPStr ) {
		String lRegexIPV6 = "([0-9A-F]{0,4}:){7}([0-9A-F]){0,4}";
		return Pattern.matches( lRegexIPV6, iIPStr );
	}

	public static boolean validateMailAddress( String iMail ){
		String lRegexMail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		return Pattern.matches( lRegexMail, iMail );
	}

	public static int parseInt( String iInput ){
		/*
		 * Implement parseInt() without using Integer Class. 
		 * 
		 * Use Ascii value to get int value. and loop through the characters
		 * multiplying a counter by 10 to keep decimal places.
		 * Throw exception when ascii value is out of range
		 * and check initial positive or negative.
		 */
		char lCharacter = iInput.charAt( 0 );
		int lAscii = lCharacter;
		// TODO
		return 0;
	}

	public static void main( String[] args ){
		System.out.println( collapseSpaces( "How    are   yo u ") );
		System.out.println( removeInbetweenSpace( "I have ,no idea. of what . I, am . doing , ") );
	}
}
