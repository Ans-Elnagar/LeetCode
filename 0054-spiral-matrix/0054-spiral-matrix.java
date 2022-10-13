class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        int iStart=0, jStart=0;
        int height = matrix.length, width = matrix[0].length;
        while(true){
            for(int j=jStart; j< width- jStart; j++){
                list.add(matrix[iStart][j]);
            }
            for(int i=iStart+1; i < height - iStart; i++){
                list.add(matrix[i][width-jStart-1]);
            }
            
            if(height - iStart - 1 > iStart)
                for(int j=width-jStart-2; j>=jStart; j--){
                    list.add(matrix[height-iStart-1][j]);
                }
            if(jStart < width-jStart-1)
                for(int i=height-iStart-2; i > iStart; i--){
                    list.add(matrix[i][jStart]);
                }
            iStart++;
            jStart++;
            if(iStart >= height-iStart || jStart >= width-jStart)
                break;
        }
        return list;
    }
}