class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new LinkedList<>();
        int len = s.length();
        int sz = p.length();
        if(len<sz)
            return indices;
        int[] occur = new int[26];
        for(int j=0; j<26; j++)
            occur[j] = 0;
        for(int j=0; j<sz; j++){
            occur[p.charAt(j)-'a']++;
        }
        int i=0;
        for(; i<sz; i++)
            occur[s.charAt(i)-'a']--;
        if(isAnagram(occur))
            indices.add(0);
        for(; i<len; i++){
            occur[s.charAt(i-sz)-'a']++;
            occur[s.charAt(i)-'a']--;
            if(isAnagram(occur))
                indices.add(i-sz+1);
        }
        return indices;
    }
    private boolean isAnagram(int[] occur){
        for(int i: occur)
            if(i!=0)
                return false;
        return true;
    }
}