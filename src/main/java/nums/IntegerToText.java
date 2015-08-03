package nums;

public class IntegerToText {

	// Print numbers from 1 to 100
	private static enum eUnit{
		ZERO( "" ), ONE( "ONE" ), TWO( "TWO" ), THREE( "THREE" ), FOUR( "FOUR" ),
		FIVE( "FIVE" ), SIX( "SIX" ), SEVEN( "SEVEN" ), EIGHT( "EIGHT" ), NINE( "NINE" );

		private final int mIndex;
		private String mName;

		private eUnit( String iName ){
			this.mIndex = ordinal();
			mName = iName;
		}

		@Override
		public String toString(){
			return mName;
		}
	}

	private static enum eFromTenToTwenty{
		TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, FIFTEEN, SIXTEEN, SEVENTEEN, EIGHTTEEN, NINETEEN;

		private final int mIndex;
		private eFromTenToTwenty(){
			this.mIndex = ordinal();
		}
	}

	private static enum eTens{
		ZERO, TEN, TWENTY, THIRTY, FOURTY, FIFTY, SIXTY, SEVENTY, EIGHTY, NINETY;

		private final int mIndex;
		private eTens( ){
			this.mIndex = ordinal();
		}
	}

	public static String fromIntegerToText( int iNumber ){
		if ( iNumber < 1 )
			throw new UnsupportedOperationException();
		if ( iNumber < 10 )
			return printUnits( iNumber );
		if ( iNumber < 20 )
			return printFromTenToTwenty( iNumber );
		if ( iNumber < 100 )
			return printTens( iNumber ) + printUnits( iNumber % 10 );
		throw new UnsupportedOperationException();
	}

	private static String printUnits( int iNumber ){
		if ( iNumber > 0 && iNumber < 10 )
			return eUnit.values()[ iNumber ].toString();
		return eUnit.values()[ iNumber % 10 ].toString();
	}

	private static String printFromTenToTwenty( int iNumber ){
		if ( iNumber > 9 && iNumber < 20 )
			return eFromTenToTwenty.values()[ iNumber % 10 ].name();
		throw new UnsupportedOperationException();
	}

	private static String printTens( int iNumber ){
		return eTens.values()[ Math.abs( ( iNumber / 10 ) % 10 ) ].name();
	}

	public static void main( String[] args ){
		System.out.println( "23: " + fromIntegerToText( 13 ) );
		System.out.println( "5: " + fromIntegerToText( 5 ) );
		System.out.println( "23: " + fromIntegerToText( 23 ) );
		System.out.println( "40: " + fromIntegerToText( 40 ) );
		System.out.println( "72: " + fromIntegerToText( 72 ) );
		System.out.println( "18: " + fromIntegerToText( 18 ) );
		System.out.println( "4: " + fromIntegerToText( 4 ) );
		System.out.println( "95: " + fromIntegerToText( 95 ) );
	}

}
