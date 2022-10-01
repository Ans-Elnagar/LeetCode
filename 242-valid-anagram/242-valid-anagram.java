class Solution {
    public boolean isAnagram(String s, String t) {
        int[] chars = new int[26];
        int lenS = s.length();
        int lenT = t.length();
        if(lenS != lenT)
            return false;
        for(int i=0; i<lenS; i++){
            chars[s.charAt(i)-'a']++;
            chars[t.charAt(i)-'a']--;
        }
        for(int count: chars)
            if(count != 0)
                return false;
        return true;
    }
}