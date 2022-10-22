class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<grid.length; i++)
        	for(int j=0; j<grid[0].length; j++)
        		if(grid[i][j] == 2) {
        			q.add(i);
        			q.add(j);
        		}
        int sz, i, j, dp=0;
        while(!q.isEmpty()) {
        	sz = q.size()/2;
        	while(sz-->0) {
        		i = q.poll();
             	j = q.poll();
             	if(i>0) {
             		if(grid[i-1][j] == 1) {
             			grid[i-1][j] = 2;
             			q.add(i-1);
             			q.add(j);
             		}
             	}
             	if(j>0) {
             		if(grid[i][j-1] == 1) {
             			grid[i][j-1] = 2;
             			q.add(i);
             			q.add(j-1);
             		}
             	}
             	if(i<grid.length-1) {
             		if(grid[i+1][j] == 1) {
             			grid[i+1][j] = 2;
             			q.add(i+1);
             			q.add(j);
             		}
             	}
             	if(j<grid[0].length-1) {
             		if(grid[i][j+1] == 1) {
             			grid[i][j+1] = 2;
             			q.add(i);
             			q.add(j+1);
             		}
             	}
        	}
            if(!q.isEmpty())
                dp++;
        }
        for(i=0; i<grid.length; i++)
        	for(j=0; j<grid[0].length; j++)
        		if(grid[i][j] == 1)
        			return -1;
		return dp;
    }
}