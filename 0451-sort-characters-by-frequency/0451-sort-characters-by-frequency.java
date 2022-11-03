class Solution {
    public String frequencySort(String s) {
        int[] count = new int[128];
        
        int len = s.length();
        for(int i=0; i<len; i++)
            count[s.charAt(i)]++;
        
        PriorityQueue<Character> queue = new PriorityQueue<>((Character c1, Character c2) -> count[c2]-count[c1]);
        for(int i=0; i<count.length; i++)
            if(count[i] > 0)
                queue.add((char)i);
        
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            char c = queue.remove();
            while(count[c]-->0)
                sb.append(c);
        }
        return sb.toString();
    }
}