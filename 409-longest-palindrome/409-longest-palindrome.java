class Solution {
    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: chars){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
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