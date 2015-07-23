package nums;

import java.util.HashMap;
import java.util.Map;

public class ArrayPairSum {

	public static void printSumPairs(int[] input, int k) {

		Map<Integer, Integer> pairs = new HashMap<>();

		// The key to solving is adding numbers to the map that would sum k
		// if we find a 4 in the array, we add 6 ( k - input[i]) to the map
		// and if it is found in the future, it will be printed out
		for (int i = 0; i < input.length; i++) {
			//System.out.println( "---- " + i + " input " + input[i] + " pairs " + pairs.get( i ) + " ----");
			if (pairs.containsKey( input[i]) )
				System.out.println( input[i] + ", " + pairs.get( input[i]) );
			else{
				//System.out.println( "put " + ( k - input[i] ) + "," + input[i] );
				pairs.put( k - input[i], input[i] );
			}
		}

	}

	public static void main( String[] args ) {        

	    int []a = {2,45,7,3,5,1,7,4,5,2,8,9};
	    printSumPairs(a,10);        

	}
}
