class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] rans = new int[26];
        int[] mag = new int[26];
        int lenR = ransomNote.length();
        int lenM = magazine.length();
        for(int i=0; i<lenR; i++)
            rans[ransomNote.charAt(i)-'a']++;
        for(int i=0; i<lenM; i++)
            mag[magazine.charAt(i)-'a']++;
        for(int i=0; i<26; i++)
            if(rans[i] > mag[i])
                return false;
        return true;
    }
}