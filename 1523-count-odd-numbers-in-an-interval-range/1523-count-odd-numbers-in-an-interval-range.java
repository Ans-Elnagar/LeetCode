class Solution {
    public int countOdds(int low, int high) {
        int all = high - low;
        int count=all/2;
        if(low%2 == 1 || all%2 == 1)
            count++;
        return count;
        
    }
}