package nums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinNumberOfCoins {

	/*
	 *  Given a list of coins and the total amount.
	 *  Calculate the minimum number of coins can be used to reach the total amount.
	 *
	 *  Greedy algorithm. Sort coins by their nominals in descending order.
	 *  Use as much amount of current nominals as possible,
	 *  then to smaller one, and so on.
	 *  The final rest part can be summed up with 1's.
	 *
	 */

	public static int minNumberOfCoins( Integer[] iCoins, int lTotalAmount ){
		List<Integer> lCoins = new ArrayList<>( Arrays.asList( iCoins ) );
		// Sort collection in reverse order to try coins from highest to lowest value
		Collections.sort( lCoins, new Comparator<Integer>() {
			@Override
			public int compare( Integer x, Integer y ){
				return y - x;
			}
		} );
		int lTotalCoins = 0;
		int lSub = lTotalAmount;
		int lIndex = 0;
		while ( lSub != 0 ){
			int lCurrentCoin = lCoins.get( lIndex );
			if ( lCurrentCoin > lSub ){
				// If the value of the coin is too high, we try with the next one
				lIndex++;
			} else {
				// Subtract value from remainder and one coin used
				lSub -= lCurrentCoin;
				lTotalCoins++;
			}
		}
		return lTotalCoins;
	}

	public static void main( String[] args ){
		// Boxing into integers
		Integer[] lListOfCoins = { 1, 2, 5, 10, 25, 50, 100, 500 };
		System.out.println( "Coins needed for 1089: " + minNumberOfCoins( lListOfCoins, 1089 ) );
	}
}
