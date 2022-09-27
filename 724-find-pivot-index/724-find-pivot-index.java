class Solution {
    public int pivotIndex(int[] nums) {
        int[] presum = new int[nums.length];
        presum[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            presum[i] = presum[i-1] + nums[i];
        }
        int right = presum[presum.length-1];
        for(int i=0; i<nums.length; i++){
            int sumLeft = presum[i] - nums[i];
            int sumRight = right - presum[i];
            if(sumLeft == sumRight)
                return i;
        }
        return -1;
    }
}