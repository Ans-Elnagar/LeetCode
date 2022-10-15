class Solution {
    public void sortColors(int[] nums) {
        int rend=-1, bstart = nums.length;
        for(int i=0; i<bstart; i++){
            if(nums[i] == 0){
                rend++;
                if(i != rend){
                    nums[rend] = 0;
                    nums[i] = 1;
                }
            }else if(nums[i] == 2){
                bstart--;
                nums[i] = nums[bstart];
                nums[bstart] = 2;
                i--;
            }
        }
    }
}