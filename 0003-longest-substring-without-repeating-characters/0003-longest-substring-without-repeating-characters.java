class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Integer> set = new HashSet<>();
        int i=0, j=0;
        int max = 0;
        int len = s.length();
        while(j < len){
            if(set.contains(s.charAt(j)-'a')){
                set.remove(s.charAt(i)-'a');
                i++;
                continue;
            }
            set.add(s.charAt(j)-'a');
            if(max < j-i+1){
                max = j-i+1;
            }
            j++;
        }
        return max;
    }
}