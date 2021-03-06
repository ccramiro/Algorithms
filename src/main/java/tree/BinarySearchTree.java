package tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {

	public Node<T> mRoot;

	// Insert a new node
	public void insert( T iValue ){
		Node<T> iNode = new Node<T>( iValue );

		if ( null == mRoot ){
			mRoot = iNode;
			return;
		}

		insert( mRoot, iNode );
	}

	private void insert( Node<T> iCurrentRoot, Node<T> iNode ){
		// Reconsider current root - moving left or right down the tree
		if( iCurrentRoot.mValue.compareTo( iNode.mValue ) > 0){
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
	public T getMin(){
		if ( null == mRoot ){
			return null;
		}

		Node<T> lNode = mRoot;
		while ( null != lNode.mLeft ){
			lNode = lNode.mLeft;
		}
		return lNode.mValue;
	}

	public T getMinRec(){
		return getMinRec( mRoot );
	}

	public T getMinRec( Node<T> iRoot ){
		if ( null == iRoot )
			return null;
		if ( null == iRoot.mLeft )
			return iRoot.mValue;

		return getMinRec( iRoot.mLeft );
	}

	// Traversing tree to the rightmost element
	public T getMax(){
		if ( null == mRoot ){
			return null;
		}

		Node<T> lNode = mRoot;
		while ( null != lNode.mRight ){
			lNode = lNode.mRight;
		}
		return lNode.mValue;
	}

	public void inOrder( ){
		inOrder( mRoot );
		System.out.println();
	}

	private void inOrder( Node<T> iRoot ){
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

	private void preOrder( Node<T> iRoot ){
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

	private void postOrder( Node<T> iRoot ){
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

	private int duplicates( Node<T> iRoot, int lValue ){
		if ( null == iRoot ){
			return 0;
		}

		int c = 0;
		if ( iRoot.mValue.equals( lValue ) ){
			c++;
		}
		return c + duplicates( iRoot.mLeft, lValue ) + duplicates( iRoot.mRight, lValue );
	}

	public int countNodes(){
		return countNodes( mRoot );
	}

	private int countNodes( Node<T> iNode ){
		if ( null == iNode ){
			return 0;
		}

		return 1 + countNodes( iNode.mLeft ) + countNodes( iNode.mRight );
	}

	 public boolean validateBST(){
		 return validateBST( mRoot, getMin(), getMax() );
	 }

	 private boolean validateBST( Node<T> iRoot, T iLeft, T iRight ){
		 if ( null == iRoot )
			 return true;
		 if ( iRoot.mValue.compareTo( iLeft ) < 0 || iRoot.mValue.compareTo( iRight ) > 0 ){
			 return false;
		 }
		 return validateBST( iRoot.mLeft, iLeft, iRoot.mValue ) && validateBST( iRoot.mRight, iRoot.mValue, iRight );
	 }

	public int depthOf( T iValue ){
		return depth( mRoot, new Node<T>( iValue ) );
	}

	private int depth( Node<T> lCurrentNode, Node<T> iNode ){
		if ( null == lCurrentNode ){
			return 0;
		}

		if ( lCurrentNode.mValue == iNode.mValue )
			return 1;
		else if ( lCurrentNode.mValue.compareTo( iNode.mValue ) > 0 )
			return 1 + depth( lCurrentNode.mLeft, iNode );
		else {
			return 1 + depth( lCurrentNode.mRight, iNode );
		}

	}

	public Node<T> findLeastCommonAncestor( T a, T b ){
		return findLeastCommonAncestor( this.mRoot, a, b );
	}

	private Node<T> findLeastCommonAncestor( Node<T> iNode, T a, T b ){
		if ( null == iNode )
			return null;
		// searching targets from top down
		if ( iNode.mValue.compareTo( a ) > 0 && iNode.mValue.compareTo( b ) > 0 ) {
			// targets to the left
			return findLeastCommonAncestor( iNode.mLeft, a, b );
		} else if ( iNode.mValue.compareTo( a ) < 0 && iNode.mValue.compareTo( b ) < 0 ) {
			// targets to the right
			return findLeastCommonAncestor( iNode.mRight, a, b );
		} else {
			// target in between
			return iNode;
		}
	}

	public int depth(){
		return depth( mRoot );
	}

	private int depth( Node<T> iNode ){
		if ( null == iNode )
			return 0;

		int lDepthLeft = 1 + depth( iNode.mLeft );
		int lDepthRight = 1 + depth( iNode.mRight );

		return lDepthLeft > lDepthRight? lDepthLeft : lDepthRight;
	}

	public boolean hasCycle( ) {
		return hasCycle( mRoot, new ArrayList<Node<T>>() );
	}

	private boolean hasCycle( Node<T> iNode, List<Node<T>> iVisited ){
		if ( null == iNode )
			return false;

		iVisited.add( iNode );

		// If the child is in the visited list, it has cycles
		if ( iVisited.contains( iNode.mLeft ) ||
				iVisited.contains( iNode.mRight ) )
			return true;

		return hasCycle( iNode.mLeft, iVisited ) ||
				hasCycle( iNode.mRight, iVisited );
	}

	public static void main( String[] args ) {
		BinarySearchTree<Integer> lBST = new BinarySearchTree<>();
		lBST.insert( 5 );
		lBST.insert( 2 );
		lBST.insert( 6 );
		lBST.insert( 8 );
		lBST.insert( 11 );
		lBST.insert( 3 );
		lBST.insert( 4 );
		lBST.insert( 13 );
		lBST.insert( 12 );
		lBST.insert( 7 );
		TreePrinter.printNode( lBST.mRoot );
		System.out.println( "Min: " + lBST.getMin() );
		System.out.println( "MinRec: " + lBST.getMinRec() );
		System.out.println( "Max: " + lBST.getMax() );
		lBST.preOrder();
		lBST.inOrder();
		lBST.postOrder();
		System.out.println( "Duplicates of 4: " + lBST.duplicates( 4 ) );
		System.out.println( "Number of nodes: " + lBST.countNodes() );
		System.out.println( "Depth of 11: " + lBST.depthOf( 11 ) );
		System.out.println( "Least Common Ancestor of 1 and 6: " + lBST.findLeastCommonAncestor( 1, 6 ) );
		System.out.println( "Total depth: " + lBST.depth() );
		System.out.println( "Is a valid BST: " + lBST.validateBST() );
		System.out.println( "Does it have cycles? " +lBST.hasCycle() );
	}

}
