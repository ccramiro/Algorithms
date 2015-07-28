package nums;

import java.util.Random;

public class ShuffleArray {

	// Fisher-Yates shuffle implementation

	public static void shuffleArray( int[] iNumbers ){
		Random lRnd = new Random();
		for ( int i = iNumbers.length - 1; i > 0 ; i-- ){
			int lRndIndex = lRnd.nextInt( i + 1 );

			// Swapping values:
			int lAux = iNumbers[ lRndIndex ]; // save value of random position
			iNumbers[ lRndIndex ] = iNumbers[ i ]; // new rnd position gets old value
			iNumbers[ i ] = lAux; // filling last position of array with value in rnd position

			/*
			 * Comment this in to understand of the swapping works
			System.out.println( "Swapping " + lRndIndex );
		    for (int j = 0; j < iNumbers.length; j++)
		    {
		      System.out.print( iNumbers[j] + " ");
		    }
		    System.out.println();
		    */
		}
	}

	public static void main(String args[])
	  {
	    int[] solutionArray = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	    shuffleArray(solutionArray);
	    for (int i = 0; i < solutionArray.length; i++)
	    {
	      System.out.print(solutionArray[i] + " ");
	    }
	    System.out.println();
	  }
}
