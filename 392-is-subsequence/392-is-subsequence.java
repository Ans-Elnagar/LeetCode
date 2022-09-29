class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0, j=0;
        int lenS = s.length();
        int lenT = t.length();
        while(i < lenS && j < lenT){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == lenS;
    }
}