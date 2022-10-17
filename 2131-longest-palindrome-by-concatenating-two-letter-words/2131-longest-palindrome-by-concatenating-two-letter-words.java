class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(String word: words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        int len=0;
        for(String word: map.keySet()){
            if(word.charAt(0) == word.charAt(1) && map.get(word) % 2 == 1){
                len = 2;
                map.put(word, map.get(word) - 1);
                break;
            }
        }
        
        for(String word: map.keySet()){
            String rev = word.charAt(1) + "" + word.charAt(0);
            if(rev.equals(word)){
                int count = map.get(word)/2;
                len += count * 4;
            }else if(map.get(word) > 0 && map.containsKey(rev) && map.get(rev) > 0){
                int count = Math.min(map.get(word), map.get(rev));
                map.put(word, map.get(word) - count);
                map.put(rev, map.get(rev) - count);
                len += count * 4;
            }
        }
        return len;
    }
}