class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int i=0, j=1;
        set.add(nums[i]);
        for(; j<=k && j<nums.length; j++){
            if(set.contains(nums[j]))
                return true;
            set.add(nums[j]);
        }
        
        for(; j<nums.length; j++){
            set.remove(nums[i]);
            i++;
            if(set.contains(nums[j]))
                return true;
            set.add(nums[j]);
        }
        return false;
    }
}