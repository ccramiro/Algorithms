package recursivity;

public class SimpleOperations {

	public static int findBinaryOnes( int iNumber ){

		if ( iNumber == 0 )
			return 0;
		if ( iNumber == 1 )
			return 1;
		int lVal = iNumber % 2;

		return lVal + findBinaryOnes( iNumber / 2 );
	}

	public static int factorial( int iNumber ){
		if ( iNumber < 1)
			return 1;
		return iNumber * factorial( iNumber - 1 );
	}

	public static int fibonacci( int iNumber ){
		if ( 1 == iNumber || 2 == iNumber )
			return 1;
		return fibonacci( iNumber - 1 ) + fibonacci( iNumber - 2 );
	}

	public static void main( String[] args ){
		System.out.println( "Ones in 15: " + findBinaryOnes( 15 ) );
		System.out.println( "Ones in 16: " + findBinaryOnes( 16 ) );
		System.out.println( "Factorial of 6: " + factorial( 6 ) );
		System.out.println( "Fibonacci of 9: " + fibonacci( 9 ) );
	}

}
