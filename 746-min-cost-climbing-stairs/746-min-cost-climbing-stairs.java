class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] mem = new int[cost.length + 1];
        for(int i=0; i<cost.length; i++)
            mem[i] = -1;
        return Math.min(dp(mem, cost, 0), dp(mem, cost, 1));
    }
    private int dp(int[] mem, int[] cost, int i){
        if(i >= cost.length)
            return 0;
        if(mem[i] != -1)
            return mem[i];
        mem[i] = dp(mem, cost, i+1);
        if(mem[i] > dp(mem, cost, i+2))
            mem[i] = dp(mem, cost, i+2);
        mem[i] += cost[i];
        return mem[i];
    }
}