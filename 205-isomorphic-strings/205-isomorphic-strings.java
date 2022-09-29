class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] chars = new char[26];
        Map<Character, Character> map = new HashMap<>();
        int len = s.length();
        for(int i=0; i<len; i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)){
                if(map.get(a) != b)
                    return false;
            }else{
                map.put(a, b);
            }
        }
        Set<Character> set = new HashSet<>();
        for(char a: map.keySet()){
            if(set.contains(map.get(a)))
                return false;
            set.add(map.get(a));
        }
        return true;
    }
}