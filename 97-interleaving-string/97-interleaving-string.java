class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int k = s3.length();
        if(k != n+m)
            return false;
        int[][] mem = new int[n+1][m+1];
        for(int i=0; i<=n; i++)
            for(int j=0; j<=m; j++)
                mem[i][j] = -1;
        return dp(mem, n, m, k, s1, s2, s3) == 1;
    }
    private int dp(int[][] mem, int i, int j, int k, String s1, String s2, String s3){
        if(i == 0 && j == 0)
            return k == 0? 1: 0;
        if(i < 0 || j < 0)
            return 0;
        
        if(mem[i][j] != -1)
            return mem[i][j];
        
        mem[i][j] = 0;
        if(i > 0 && s1.charAt(i-1) == s3.charAt(k-1)){
            mem[i][j] = dp(mem, i-1, j, k-1, s1, s2, s3);
        }
        
        if(mem[i][j] != 1 && j>0 && s2.charAt(j-1) == s3.charAt(k-1) ){
            mem[i][j] = dp(mem, i, j-1, k-1, s1, s2, s3);
        }
        
        return mem[i][j];
    }
}