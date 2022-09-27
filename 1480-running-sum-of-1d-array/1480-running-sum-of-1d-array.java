class Solution {
    public int[] runningSum(int[] nums) {
        int[] presum = new int[nums.length];
        presum[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            presum[i] = presum[i-1] + nums[i];
        }
        return presum;
    }
}