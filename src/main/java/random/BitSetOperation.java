package random;

import java.util.BitSet;
import java.util.Random;

public class BitSetOperation {

	public static int[] getRandomNumbers( int iLimit, int iN  ) {
		BitSet lBitSet = new BitSet();
		for (int l = 0; l < iLimit; l++) {
			lBitSet.set( l );
		}

		int[] lOutputNumbers = new int[ iN ];
		int i = 0;
		while ( i < iN ) {
			Random rand = new Random();
			int lRnd = ( rand.nextInt( iLimit ) );
			if ( lBitSet.get( lRnd ) )
				 lOutputNumbers[i++] = lRnd;
		}
		return lOutputNumbers;
	}

	public static void main(String args[]) {
		int[] lNumbers = getRandomNumbers( 1000000, 15 );
		for ( int i : lNumbers ) {
			System.out.print( i + ", ");
		}
	}
}
