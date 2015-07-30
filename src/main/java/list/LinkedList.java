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
		// Case list empty or first element to be inserted
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

	public void remove( int iValue ){
		if ( mHead == null ){
			return;
		}

		// Case value to remove is head
		if ( mHead.mValue == iValue ){
			Node lAuxNode = mHead;
			mHead = mHead.mNext;
			lAuxNode = null;
			return;
		}

		// Iterate until finding value
		Node lAuxNode = mHead;
		while ( lAuxNode.mNext != null && lAuxNode.mNext.mValue != iValue ){
			lAuxNode = lAuxNode.mNext;
		}

		// Only remove if value was found in the list
		if ( lAuxNode.mNext != null ){
			Node lNextNode = lAuxNode.mNext;
			lAuxNode.mNext = lNextNode.mNext;
			lNextNode = null;
		}

	}

	public void reverse(){
		Node lNewList = null;
		Node lCurrentNode = mHead;
		while ( lCurrentNode != null ){
			Node lNext = lCurrentNode.mNext;
			lCurrentNode.mNext = lNewList;
			lNewList = lCurrentNode;
			lCurrentNode = lNext;
		}
		mHead = lNewList;
	}

	public int size(){
		return size( this.mHead );
	}

	public int size( Node iNode ){
		if ( null == iNode )
			return 0;

		return 1 + size( iNode.mNext );
	}

	// Test methods to speed up creation of tests
	// Just returning instance of this to speed up creation of method calls
	public LinkedList insertTest( int iValue ){
		insert( iValue );
		return this;
	}

	public LinkedList removeTest( int iValue ){
		remove( iValue );
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
		 .insertTest( 12 )
		 .removeTest( 8 )
		 .removeTest( 1 )
		 .removeTest( 7 )
		 .removeTest( 5 )
		 .removeTest( 14 )
		 .insertTest( 7 );
		System.out.println( "List " + m );
		m.reverse();
		System.out.println( "List " + m );
		System.out.println( "Size: " + m.size() );
	}

}
