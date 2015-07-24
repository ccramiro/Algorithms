package tree;

class Node {

    Node mLeft, mRight;
    int mValue;

    public Node( int iValue ) {
        this.mValue = iValue;
    }

	@Override
	public String toString(){
		return Integer.toString( this.mValue );
	}

}