class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        boolean reverse = false;
        double result = 1;
        if(n == Integer.MIN_VALUE){
            result *= x;
            n++;
        }
        if(n < 0){
            n *= -1;
            reverse = true;
        }
        double pow = x;
        while(n > 0){
            if( (n&1) == 1 ){
                result *= pow;
            }
            pow *= pow;
            n = n >> 1;
        }
        return reverse? 1/result : result;
    }
}