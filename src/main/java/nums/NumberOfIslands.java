package nums;

public class NumberOfIslands {

	private static enum Direction {
        LU( -1, -1),
        U ( 0, -1 ),
        RU( -1, 1 ),
        R ( 0, 1 ),
        RD( 1, 1 ),
        D ( 1, 0 ),
        LD( 1, -1 ),
        L ( -1, 0 );

        int mRow;
        int mCol;

        private Direction(int iRow, int iCol) {
            this.mRow = iRow;
            this.mCol = iCol;
        }

        public int getRow() { return mRow; }
        public int getCol() { return mCol; }

    }

    private static boolean isValid( int iRow, int iCol, Direction direction, int[][] iLandMap, int[][] iVisited ) {
    	// Checking if out-of-bounds
        if ( iRow < 0 || iRow >= iVisited.length )
        	return false;
        if ( iCol < 0 || iCol >= iVisited[0].length )
        	return false;
        // Already visited positions, we have been here before checking for islands
        if ( 1 == iVisited[iRow][iCol] )
        	return false;
        // Valid : needs to be visited and attached to an island
        return 1 == iLandMap[iRow][iCol];
    }

    private static void visitAdjacent( int iRow, int iCol, int[][] iLandMap, int[][] iVisited ) {
    	// New island : marked as visited
        iVisited[iRow][iCol] = 1;
        // Checking all adjacent positions : if we find a 1, it will be
        // marked as visited. Is not a new isolated island, but and adjacent of the
        // one we are checking currently - we attach it to the current one
        for ( Direction direction : Direction.values() ) {
            int newRow = iRow + direction.getRow();
            int newCol = iCol + direction.getCol();
            if ( isValid( newRow, newCol, direction, iLandMap, iVisited ) ) {
            	// Expanding the search until we are surrounded by zeros
                visitAdjacent( newRow, newCol, iLandMap, iVisited );
            }
        }
    }

    public static int countNumberOfIslands( int[][] iLandMap ) {
        final int[][] lVisited = new int[iLandMap.length][iLandMap[0].length];
        int lIslandCounter = 0;

        for ( int lRow = 0; lRow < iLandMap.length; lRow++ ) {
            for ( int lCol = 0; lCol < iLandMap[0].length; lCol++ ) {
                if ( iLandMap[lRow][lCol] == 1 && lVisited[lRow][lCol] == 0 ) {
                	// Visit only new island to mark adjacent
                	// islands as visited ( they will not be checked again )
                    visitAdjacent( lRow, lCol, iLandMap, lVisited );
                    lIslandCounter++;
                }
            }
        }
        return lIslandCounter;
    }

    public static void main( String[] args ) {
        int[][] lLandMap1 = { { 1, 0, 1 },
        		              { 0, 1, 0 },
        		              { 0, 0, 0 } };

        System.out.println( "One island created, found " + countNumberOfIslands( lLandMap1 ) );

        int[][] lLandMap2 = { {1, 1, 0, 0, 0},
        		              {0, 1, 0, 0, 1},
        		              {1, 0, 0, 1, 1},
        		              {0, 0, 0, 0, 0},
        		              {1, 0, 1, 0, 1} };

        System.out.println( "Five islands created, found: " + countNumberOfIslands( lLandMap2 ) );

        int[][] lLandMap3 = { {1, 1, 0, 0},
	                          {0, 1, 0, 1},
	                          {1, 0, 0, 1},
	                          {0, 0, 0, 0},
	                          {1, 0, 1, 0} };

        System.out.println( "Four islands created, found: " + countNumberOfIslands( lLandMap3 ) );

    }

}
