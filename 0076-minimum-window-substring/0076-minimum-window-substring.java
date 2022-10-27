class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m == 1)
            return s.equals(t)? s: "";
        else if(n == 1)
            return s.contains(t)? t: "";
        int lenOfArray = 'z' - 'A'+1;
        int[] required = new int[lenOfArray];
        for(int i=0; i<n; i++)
            required[t.charAt(i)-'A']++;
        int[] containedInSub = new int[lenOfArray];
        int min = Integer.MAX_VALUE;
        String out = "";
        
        int left = 0, right = 1;
        containedInSub[s.charAt(0)-'A']++;
        containedInSub[s.charAt(1)-'A']++;
        while(true){
            if(validSub(required, containedInSub)){
                if(right-left+1 < min){
                    min = right-left+1;
                    out = s.substring(left, right+1);
                }
                containedInSub[s.charAt(left)-'A']--;
                left++;
            }else{
                right++;
                if(right >= m)
                    break;
                containedInSub[s.charAt(right)-'A']++;
            }
        }
        return out;
    }
    private boolean validSub(int[] required, int[] containedInSub){
        for(int i=0; i<required.length; i++){
            if(required[i] > containedInSub[i])
                return false;
        }
        return true;
    }
}