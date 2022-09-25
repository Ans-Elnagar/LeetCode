class Solution {
    public int tribonacci(int n) {
        if(n <= 1)
            return n;
        else if( n == 2)
            return 1;
        int t0=0, t1=1, t2=1;
        int t3 = 2;
        for(int i=3; i<n; i++){
            t0 = t1;
            t1 = t2;
            t2 = t3;
            t3 = t0 + t1 + t2;
        }
        return t3;
    }
}