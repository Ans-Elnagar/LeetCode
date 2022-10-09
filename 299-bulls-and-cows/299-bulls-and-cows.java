class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, LinkedList<Integer>> map = new HashMap<>();
        int len = secret.length();
        boolean[] taken = new boolean[len];
        for(int i=0; i<len; i++){
            char key = secret.charAt(i);
            if( ! map.containsKey(key))
                map.put(key, new LinkedList<Integer>());
            map.get(key).add(i);
        }
        int x=0;
        for(Integer i=0; i<len; i++){
            char key = guess.charAt(i);
            if(map.containsKey(key)){
                if(map.get(key).contains(i)){
                    x++;
                    taken[i] = true;
                    map.get(key).remove(i);
                }
            }
        }
        int y=0;
        for(Integer i=0; i<len; i++){
            char key = guess.charAt(i);
            if( !taken[i] && map.containsKey(key)){
                if(map.get(key).size() > 0){
                    y++;
                    map.get(key).remove(0);
                }
            }
        }
        return x+"A"+y+"B";
    }
}