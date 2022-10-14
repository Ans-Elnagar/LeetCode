class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(String s: strs)
            prefix = lognestCommonPrefix(prefix, s);
        return prefix;
    }
    private String lognestCommonPrefix(String s1, String s2){
        int len = Math.min(s1.length(), s2.length());
        String prefix = "";
        for(int i=0; i<len; i++){
            if(s1.charAt(i) != s2.charAt(i))
                break;
            prefix += s1.charAt(i);
        }
        return prefix;
    }
}