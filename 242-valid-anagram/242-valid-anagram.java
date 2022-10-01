class Solution {
    public boolean isAnagram(String s, String t) {
        int[] ss = new int[26];
        int[] tt = new int[26];
        int lenS = s.length();
        int lenT = t.length();
        for(int i=0; i<lenS; i++)
            ss[s.charAt(i)-'a']++;
        for(int i=0; i<lenT; i++)
            tt[t.charAt(i)-'a']++;
        for(int i=0; i<26; i++)
            if(ss[i] != tt[i])
                return false;
        return true;
    }
}