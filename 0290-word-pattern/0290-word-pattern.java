class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> taken = new HashSet<>();
        String[] strs = s.split(" ");
        int len = pattern.length();
        if(len != strs.length)
            return false;
        for(int i=0; i<len; i++){
            if(map.containsKey(pattern.charAt(i))) {
               if(!map.get(pattern.charAt(i)).equals(strs[i]))
                return false;
            }else{
                if(taken.contains(strs[i]))
                    return false;
                taken.add(strs[i]);
                map.put(pattern.charAt(i), strs[i]);
            }
        }
        return true;
    }
}