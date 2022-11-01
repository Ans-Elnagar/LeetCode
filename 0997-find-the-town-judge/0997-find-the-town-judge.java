class Solution {
    public int findJudge(int n, int[][] trust) {
        boolean[] notJudge = new boolean[n+1];
        int[] trustedBy = new int[n+1];
        for(int[] t: trust){
            notJudge[t[0]] = true;
            trustedBy[t[1]]++;
        }
        for(int i=1; i<=n; i++){
            if( !notJudge[i] && trustedBy[i] == n-1)
                return i;
        }
        return -1;
    }
}