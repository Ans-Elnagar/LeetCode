class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1+len2+1];
        for(int i=len1-1; i>=0; i--){
            int a = num1.charAt(i) - '0';
            for(int j=len2-1; j>=0; j--){
                int c = a * (num2.charAt(j) - '0');
                result[len1+len2-i-j-2] += c%10;
                result[len1+len2-i-j-1] += c/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < result.length-1; i++){
            if(result[i] >= 10){
                result[i+1] += result[i]/10;
                result[i] = result[i] % 10;
            }
        }
        for(int i=result.length-1; i >= 0; i--){
            if(result[i] == 0 && sb.length() == 0)
                continue;
            sb.append(result[i]);
        }
        if(sb.length() == 0)
            return "0";
        return sb.toString();
    }
}