class Solution {
    public int threeSumClosest(int[] nums, int target) {
        TreeSet<Integer> tree = new TreeSet<>();
        int closest = 100000;
        tree.add(nums[0]);
        for(int i=1; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                Integer num = tree.ceiling(target-nums[i]-nums[j]);
                if(num != null){
                    if(Math.abs(target-nums[i]-nums[j]-num) < Math.abs(target-closest))
                        closest = nums[i] + nums[j] + num;
                }
                num = tree.floor(target-nums[i]-nums[j]);
                if(num != null){
                    if(Math.abs(target-nums[i]-nums[j]-num) < Math.abs(target-closest))
                        closest = nums[i] + nums[j] + num;
                }
            }
            tree.add(nums[i]);
        }
        return closest;
    }
}