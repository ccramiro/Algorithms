package list;

public class QuickSort {

	public static void sort( int[] iNumbers ) {
		sort( iNumbers, 0, iNumbers.length - 1 );
	}

	static void sort( int[] iNumbers, int lStartIndex, int lEndIndex ){
		// Splitting and calculating pivot
		int lIndex = partition( iNumbers, lStartIndex, lEndIndex );
		if ( lStartIndex < lEndIndex -1 ){
			sort( iNumbers, lStartIndex, lIndex - 1);
		}
		if ( lEndIndex > lIndex ){
			sort( iNumbers, lIndex, lEndIndex );
		}
	}

	static int partition( int[] iNumbers,int iLeft, int iRight ){
		int lPivot = iNumbers[ iLeft ];

		while ( iLeft <= iRight ){
			while ( iNumbers[ iLeft ] < lPivot )
				iLeft++;
			while ( iNumbers[ iRight ] > lPivot)
				iRight--;

			// Swapping
			if ( iLeft <= iRight ) {
				int lTmp = iNumbers[ iLeft ];
				iNumbers[ iLeft ] = iNumbers[ iRight ];
				iNumbers[ iRight ] = lTmp;

				iLeft++;
				iRight--;
			}
		}
	    return iLeft;
	}

	public static void main( String[] args ){
		int[] lNumbers = { 15, 3, 21, 6, 29, 33, 12, 21, 53, 31, 17};
		QuickSort.sort( lNumbers );
		for ( int i : lNumbers ) {
			System.out.print( i + ", " );
		}
	}
}
