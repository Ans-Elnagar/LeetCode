class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] count1 = new int[1001];
        int[] count2 = new int[1001];
        for(int num: nums1){
            count1[num]++;
        }
        for(int num: nums2){
            count2[num]++;
        }
        int size = 0;
        for(int i=0; i<=1000; i++){
            count1[i] = Math.min(count1[i], count2[i]);
            size += count1[i];
        }
        int[] result = new int[size];
        int j=0;
        for(int i=0; i<=1000; i++){
            while(count1[i]-- > 0){
                result[j] = i;
                j++;
            }
        }
        return result;
    }
}