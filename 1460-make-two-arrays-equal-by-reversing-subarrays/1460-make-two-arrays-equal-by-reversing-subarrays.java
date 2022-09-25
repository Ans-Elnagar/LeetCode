class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] counter = new int[1001];
        Set<Integer> set = new HashSet<>();
        for(int num: target){
            counter[num]++;
            set.add(num);
        }
        for(int num: arr){
            counter[num]--;
            set.add(num);
        }
        for(Integer num: set)
            if(counter[num] != 0)
                return false;
        return true;
    }
}