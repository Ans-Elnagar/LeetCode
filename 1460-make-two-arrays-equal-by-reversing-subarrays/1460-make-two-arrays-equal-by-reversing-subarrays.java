class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] counter = new int[1001];
        for(int num: target)
            counter[num]++;
        for(int num: arr)
            counter[num]--;
        for(int i=0; i<=1000; i++)
            if(counter[i] != 0)
                return false;
        return true;
    }
}