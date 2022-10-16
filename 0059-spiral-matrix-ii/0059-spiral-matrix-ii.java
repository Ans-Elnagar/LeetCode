class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int iStart=0, jStart=0;
        int count = 1;
        while(true){
            for(int j=jStart; j< n - jStart; j++){
                matrix[iStart][j] = count++;
            }
            for(int i=iStart+1; i < n - iStart; i++){
                matrix[i][n-jStart-1] = count++;
            }
            
            if(n - iStart - 1 > iStart)
                for(int j=n-jStart-2; j>=jStart; j--){
                    matrix[n-iStart-1][j] = count++;
                }
            if(jStart < n-jStart-1)
                for(int i=n-iStart-2; i > iStart; i--){
                    matrix[i][jStart] = count++;
                }
            iStart++;
            jStart++;
            if(iStart >= n-iStart || jStart >= n-jStart)
                break;
        }
        return matrix;
    }
}