class Solution {
    public int countOdds(int low, int high) {
        int all = high - low;
        return all/2 
            + ((low%2==1 || all%2==1)? 1: 0);
    }
}