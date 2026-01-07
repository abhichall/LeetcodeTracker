class Vector2D {

    private int[][] vec;
    private int row = 0;
    private int col = 0;

    public Vector2D(int[][] vec) {
        this.vec = vec;
    }
    
    public int next() {
        hasNext();
        return vec[row][col++];
        
    }
    
    public boolean hasNext() {
        
        while (row < vec.length && col >= vec[row].length) {
            row++;
            col = 0;
        }

        return row < vec.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

 /**
 
 list or array
 2d - list of listsf

 have an iterator, can go through every elemnts as if its single list
 
 two indexes
    tracks row

    tracks col

    next()
        vector[row][col++] -- if this has value then we can return

    hasNext()
        check a row in advance 
 
  */