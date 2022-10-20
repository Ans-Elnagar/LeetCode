class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1){
            if(nums[0] == target)
                return 0;
            return -1;
        }
        int r=0;
        if(nums[0] >= nums[nums.length-1])
            r = findRealStart(nums);
        if(target > nums[nums.length-1])
            return bs(nums, 0, r-1, target);
        return bs(nums, r, nums.length-1, target);
    }
    private int findRealStart(int[] nums){
        int low=1, high = nums.length-1, mid = 0;
        int last = nums[high];
        while(low<=high){
            mid = (low+high)/2;
            if(nums[mid] > last){
                low = mid+1;
                continue;
            }
            if(nums[mid] < nums[mid-1])
                break;
            high = mid - 1;
        }
        return mid;
    }
    private int bs(int[] nums, int low, int high, int target){
        if(low > high)
            return -1;
        int mid = (low + high) / 2;
        if(nums[mid] == target)
            return mid;
        if(nums[mid] < target)
            return bs(nums, mid+1, high, target);
        return bs(nums, low, mid-1, target);
    }
}