class Solution {
    public int climbStairs(int n) {
        int[] mem = new int[n+1];
        for(int i=1; i<=n ;i++)
            mem[i] = -1;
        mem[0] = 1;
        return dp(mem, n);
    }
    private int dp(int[] mem, int n){
        if(n < 0)
            return 0;
        if(mem[n] != -1)
            return mem[n];
        mem[n] = dp(mem, n-1);
        mem[n] += dp(mem, n-2);
        return mem[n];
    }
}