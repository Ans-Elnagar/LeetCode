class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int[] firstIndex = new int[26];
        for(int i=0; i<26; i++)
            firstIndex[i] = -1;
        int len = s.length();
        for(int i=0; i<len; i++){
            int index = s.charAt(i) - 'a';
            count[index]++;
            if(firstIndex[index] == -1)
                firstIndex[index] = i;
        }
        int minIndex = len;
        for(int i=0; i<26; i++){
            if(count[i] == 1)
                if(firstIndex[i] < minIndex)
                    minIndex = firstIndex[i];
        }
        return minIndex==len? -1: minIndex;
    }
}