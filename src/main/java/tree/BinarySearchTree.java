package tree;

public class BinarySearchTree {

	public Node mRoot;

	// Insert a new node
	public void insert( int iValue ){
		Node iNode = new Node( iValue );

		if ( null == mRoot ){
			mRoot = iNode;
			return;
		}

		insert( mRoot, iNode );
	}

	private void insert( Node iCurrentRoot, Node iNode ){
		// Reconsider current root - moving left or right down the tree
		if ( iCurrentRoot.mValue > iNode.mValue ){
			if ( null == iCurrentRoot.mLeft ){
				iCurrentRoot.mLeft = iNode;
			} else {
				insert( iCurrentRoot.mLeft, iNode );
			}
		} else {
			if ( null == iCurrentRoot.mRight ){
				iCurrentRoot.mRight = iNode;
			} else {
				insert( iCurrentRoot.mRight, iNode );
			}
		}
	}

	// Traversing tree to the leftmost element
	public int getMin(){
		if ( null == mRoot ){
			return 0;
		}

		Node lNode = mRoot;
		while ( null != lNode.mLeft ){
			lNode = lNode.mLeft;
		}
		return lNode.mValue;
	}

	// Traversing tree to the rightmost element
	public int getMax(){
		if ( null == mRoot ){
			return 0;
		}

		Node lNode = mRoot;
		while ( null != lNode.mRight ){
			lNode = lNode.mRight;
		}
		return lNode.mValue;
	}

	public static void main( String[] args ) {
		BinarySearchTree lBST = new BinarySearchTree();
		lBST.insert( 5 );
		lBST.insert( 2 );
		lBST.insert( 6 );
		lBST.insert( 8 );
		lBST.insert( 11 );
		lBST.insert( 3 );
		lBST.insert( 4 );
		lBST.insert( 1 );
		lBST.insert( 19 );
		lBST.insert( 12 );
		lBST.insert( 7 );
		lBST.insert( 9 );
		TreePrinter.printNode( lBST.mRoot );
		System.out.println( "Min: " + lBST.getMin() );
		System.out.println( "Max: " + lBST.getMax() );
	}

}
