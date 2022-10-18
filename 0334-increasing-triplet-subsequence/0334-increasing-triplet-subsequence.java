class Solution {
    public boolean increasingTriplet(int[] nums) {
       int min = Integer.MAX_VALUE;
       int secondMin = Integer.MAX_VALUE;
       for(int num : nums) {
           if(num <= min)
               min = num;
           else if(num <= secondMin) 
               secondMin = num;
           else 
               // if greater than secondMin then also greater than the min previous to secondMin
               return true;
       }
       return false;
    }
}