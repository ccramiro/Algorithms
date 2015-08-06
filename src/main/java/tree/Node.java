package tree;

class Node<T> {

    public Node<T> mLeft, mRight;
    public T mValue;

    public Node( T iValue ) {
        this.mValue = iValue;
    }

	@Override
	public String toString(){
		return mValue.toString();
	}

}