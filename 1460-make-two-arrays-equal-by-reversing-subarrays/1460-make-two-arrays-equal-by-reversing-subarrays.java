class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: target){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num: arr)
            map.put(num, map.getOrDefault(num, 0) -1);
        for(int num: map.keySet()){
            if(map.get(num) != 0)
                return false;
        }
        return true;
    }
}