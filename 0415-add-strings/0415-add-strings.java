class Solution {
    public String addStrings(String num1, String num2) {
        String result = "";
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        while(i>=0 && j>=0){
            int sum = carry + num1.charAt(i) + num2.charAt(j) - 2*'0';
            carry = sum>9? 1: 0;
            sum = sum%10;
            result = sum + result;
            i--;
            j--;
        }
        while(i >= 0){
            int sum = carry + num1.charAt(i) - '0';
            carry = sum>9? 1: 0;
            sum = sum%10;
            result = sum + result;
            i--;
        }
        while(j >= 0){
            int sum = carry + num2.charAt(j) - '0';
            carry = sum>9? 1: 0;
            sum = sum%10;
            result = sum + result;
            j--;
        }
        if(carry == 1)
            result = 1 + result;
        return result;
    }
}