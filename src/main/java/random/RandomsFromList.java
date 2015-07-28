package random;

import java.util.Random;

public class RandomsFromList {

	public static int[] getRandomFromList( int[] iNumbers, int iSize ){
		Random lRnd = new Random();
		int[] lReturn = new int[iSize];
		int l = iSize;

		// Iterating iSize times
		while ( l > 0 ){
			int lIndex = lRnd.nextInt( iNumbers.length );
			lReturn[ --l ] = iNumbers[ lIndex ];
		}
		return lReturn;
	}

	public static void main( String[] args ){
		final int lN = 1000;
		int[] iNumbers = new int[lN];
		// Filling array with numbers from 0 to N
		for ( int i = 0; i < lN; i++ ) {
			iNumbers[ i ] = i;
		}

		final int lSize = 10;
		int[] lOutput = new int[lSize];
		lOutput = getRandomFromList( iNumbers, lSize );
		for ( int i : lOutput ){
			System.out.print( i + ", " );
		}
		System.out.println();
	}
}
