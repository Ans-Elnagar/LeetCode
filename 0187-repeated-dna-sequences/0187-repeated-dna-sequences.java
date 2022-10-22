class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        int len = s.length();
        if(len < 10)
            return new LinkedList<>();
        String seq = s.substring(0, 9);
        for(int i=9; i<len; i++){
            seq += s.charAt(i);
            map.put(seq, map.getOrDefault(seq, 0) + 1);
            seq = seq.substring(1);
        }
        List<String> list = new LinkedList<>();
        for(String key: map.keySet())
            if(map.get(key) > 1)
                list.add(key);
        return list;
    }
}