class Solution {
    public int longestPalindrome(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<len; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int mask = Integer.MAX_VALUE - 1;
        int size = 0;
        boolean containsOdd = false;
        for(char ch: map.keySet()){
            int count = map.get(ch);
            if( (count & 1) == 1 )
                containsOdd = true;
            size += count & mask;
        }
        return size + (containsOdd? 1: 0);
    }
}