class Solution {
    public int rob(int[] nums) {
        int[] mem = new int[nums.length];
        for(int i=0; i<mem.length; i++)
            mem[i] = -1;
        return dp(nums, mem, 0);
    }
    private int dp(int[] nums, int[] mem, int i){
        if(i >= nums.length)
            return 0;
        if(mem[i] != -1)
            return mem[i];
        return mem[i] = Math.max(dp(nums, mem, i+1), nums[i] + dp(nums, mem, i+2));
    }
}