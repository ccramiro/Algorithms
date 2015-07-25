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

	public void inOrder( ){
		inOrder( mRoot );
		System.out.println();
	}

	private void inOrder( Node iRoot ){
		if ( null == iRoot ){
			return;
		}

		inOrder( iRoot.mLeft );
		System.out.print( iRoot + ", " );
		inOrder( iRoot.mRight );
	}

	public void preOrder(){
		preOrder( mRoot );
		System.out.println();
	}

	private void preOrder( Node iRoot ){
		if ( null == iRoot ){
			return;
		}

		System.out.print( iRoot + ", " );
		preOrder( iRoot.mLeft );
		preOrder( iRoot.mRight );
	}

	public void postOrder(){
		postOrder( mRoot );
		System.out.println();
	}

	private void postOrder( Node iRoot ){
		if ( null == iRoot ){
			return;
		}

		postOrder( iRoot.mLeft );
		postOrder( iRoot.mRight );
		System.out.print( iRoot + ", " );
	}

	public int duplicates( int lValue ){
		return duplicates( this.mRoot, lValue );
	}

	private int duplicates( Node iRoot, int lValue ){
		if ( null == iRoot ){
			return 0;
		}

		int c = 0;
		if ( iRoot.mValue == lValue ){
			c++;
		}
		return c + duplicates( iRoot.mLeft, lValue ) + duplicates( iRoot.mRight, lValue );
	}

	public int countNodes(){
		return countNodes( mRoot );
	}

	private int countNodes( Node iNode ){
		if ( null == iNode ){
			return 0;
		}

		return 1 + countNodes( iNode.mLeft ) + countNodes( iNode.mRight );
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
		lBST.insert( 4 );
		lBST.insert( 12 );
		lBST.insert( 7 );
		TreePrinter.printNode( lBST.mRoot );
		System.out.println( "Min: " + lBST.getMin() );
		System.out.println( "Max: " + lBST.getMax() );
		lBST.preOrder();
		lBST.inOrder();
		lBST.postOrder();
		System.out.println( "Duplicates of 4: " + lBST.duplicates( 4 ) );
		System.out.println( "Number of nodes: " + lBST.countNodes() );
	}

}
