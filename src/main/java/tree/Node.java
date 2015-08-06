package tree;

class Node<T> {

    public Node<T> mLeft, mRight;
    public final T mValue;

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( null == mLeft ) ? 0 : mLeft.hashCode() );
		result = prime * result + ( ( null == mRight ) ? 0 : mRight.hashCode() );
		result = prime * result + ( ( null == mValue ) ? 0 : mValue.hashCode() );
		return result;
	}

	@Override
	public boolean equals( Object lObject ) {
		if ( this == lObject )
			return true;
		if ( null == lObject )
			return false;
		if ( ! ( lObject instanceof Node ) )
			return false;
		@SuppressWarnings("unchecked") // We just checked instance type
		Node<T> iOther = ( Node<T> ) lObject;
		if ( null == mLeft ) {
			if ( null != iOther.mLeft )
				return false;
		} else if ( !mLeft.equals( iOther.mLeft ) )
			return false;
		if ( null == mRight) {
			if ( null != iOther.mRight )
				return false;
		} else if ( !mRight.equals( iOther.mRight) )
			return false;
		if ( null == mValue ) {
			if ( null != iOther.mValue )
				return false;
		} else if ( !mValue.equals( iOther.mValue) )
			return false;
		return true;
	}

	public Node( T iValue ) {
        this.mValue = iValue;
    }

	@Override
	public String toString(){
		return mValue.toString();
	}

}