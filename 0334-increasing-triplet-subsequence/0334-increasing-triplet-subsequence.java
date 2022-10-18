class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] next = new int[nums.length];
        TreeMap<Long, Integer> tree = new TreeMap<>();
        tree.put(Long.MAX_VALUE, nums.length);
        for(int i=nums.length-1; i>=0; i--){
            long key = tree.ceilingKey((long)nums[i]+1);
            next[i] = tree.get(key);
            tree.put((long)nums[i], i);
        }
        for(int i=0; i<nums.length; i++){
            if(next[i] != nums.length && next[next[i]] != nums.length)
                return true;
        }
        return false;
    }
}