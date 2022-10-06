class Solution {
    public int fib(int n) {
        if(n <= 1)
            return n;
        int f0 = 0, f1 = 1, f=1;
        n -= 2;
        while(n-->0){
            f0 = f1;
            f1 = f;
            f = f0 + f1;
        }
        return f;
    }
}