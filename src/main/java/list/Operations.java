package list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Operations {

	public static <T> void removeDuplicates( List<T> iList ){
		Set<T> lSet = new HashSet<>( iList );
		iList.clear();
		iList.addAll( lSet );
	}

	public static void main( String[] args ){
		List<Integer> lIntList = new ArrayList<>();
		lIntList.add( 1 );
		lIntList.add( 2 );
		lIntList.add( 2 );
		lIntList.add( 3 );
		Operations.removeDuplicates( lIntList );
		for ( Integer iN : lIntList ){
			System.out.println( iN +" " );
		}
 	}

}
