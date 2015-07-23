package list;

public class LinkedList {

	public static class Node{
		int mValue;
		Node mNext;
		public Node( int iValue ){
			this.mValue = iValue;
		}

		@Override
		public String toString(){
			return Integer.toString( mValue );
		}
	}

	private Node mHead;

	public void insert( int iValue ){
		if ( null == mHead || mHead.mValue > iValue){
			Node lNewNode = new Node( iValue );
			lNewNode.mNext = mHead;
			mHead = lNewNode;
			return;
		}

		Node lAuxNode = mHead;
		while ( lAuxNode.mNext != null && lAuxNode.mNext.mValue < iValue ) {
			lAuxNode = lAuxNode.mNext;
		}
		Node lNew = new Node( iValue );
		lNew.mNext = lAuxNode.mNext;
		lAuxNode.mNext = lNew;
	}

	public LinkedList insertTest( int iValue ){
		insert( iValue );
		return this;
	}
	@Override
	public String toString(){
		StringBuffer lSB = new StringBuffer( "" );
		Node lAuxNode = mHead;
		while ( null != lAuxNode ){
			lSB.append( lAuxNode.mValue + ", " );
			lAuxNode = lAuxNode.mNext;
		}
		return lSB.toString();
	}

	public static void main( String[] args ){
		LinkedList m = new LinkedList();
		m.insertTest( 14 )
		 .insertTest( 5 )
		 .insertTest( 8 )
		 .insertTest( 1 )
		 .insertTest( 10 )
		 .insertTest( 5 )
		 .insertTest( 6 )
		 .insertTest( 12 );
		System.out.println( "List " + m );
	}
}
