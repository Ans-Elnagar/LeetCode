class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            String key = anagramKey(s);
            if( ! map.containsKey(key))
                map.put(key, new LinkedList<String>());
            map.get(key).add(s);
        }
        List<List<String>> list = new LinkedList<>();
        for(String key: map.keySet())
            list.add(map.get(key));
        return list;
    }
    private String anagramKey(String s){
        int[] freq = new int[26];
        int len = s.length();
        for(int i=0; i<len; i++)
            freq[s.charAt(i)-'a']++;
        return freqToString(freq);
    }
    private String freqToString(int[] freq){
        StringBuilder sb = new StringBuilder();
        for(int f: freq){
            sb.append(f+".");
        }
        return sb.toString();
    }
}