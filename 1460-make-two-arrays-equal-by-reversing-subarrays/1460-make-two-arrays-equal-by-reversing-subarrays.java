class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] counter = new int[1001];
        for(int i=0; i<target.length; i++){
            counter[target[i]]++;
            counter[arr[i]]--;
        }
        for(int num: counter)
            if(num != 0)
                return false;
        return true;
    }
}