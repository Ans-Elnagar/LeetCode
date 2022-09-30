class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if( ( m * n != r * c)
            || ( m == r && n == c) )
            return mat;
        int[][] t = new int[r][c];
        int i=0, j=0;
        for(int k=0; k<r; k++){
            for(int h=0; h<c; h++){
                if(j == n){
                    j = 0;
                    i++;
                }
                t[k][h] = mat[i][j];
                j++;
            }
        }
        return t;
    }
}