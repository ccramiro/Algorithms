package core;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class StringManipulation {

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

}
