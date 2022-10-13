class Solution {
    public int[] findBall(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        if(width == 1){
            return new int[]{-1};
        }
        int[][] mem = new int[height+1][width];
        for(int j=0; j<width; j++)
            mem[height][j] = j;
        for(int i=height-1; i>=0; i--){
            mem[i][0] = (grid[i][0] == -1 || grid[i][1] == -1) ? -1 : mem[i+1][1];
            mem[i][width-1] = (grid[i][width-1] == 1 || grid[i][width-2] == 1)? -1 : mem[i+1][width-2];  
            for(int j=1; j<width-1; j++){
                if(grid[i][j + grid[i][j]] == grid[i][j])
                    mem[i][j] = mem[i+1][j + grid[i][j]];
                else
                    mem[i][j] = -1;
            }
        }
        return mem[0];
    }
}