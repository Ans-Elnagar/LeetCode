class Solution {
    public int majorityElement(int[] nums) {
        int elem = Integer.MIN_VALUE;
        int count = 0;
        for(int num: nums){
            if(count == 0){
                elem = num;
                count = 1;
                continue;
            }
            if(elem == num)
                count++;
            else
                count--;
        }
        return elem;
    }
}