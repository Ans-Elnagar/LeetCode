class Solution {
    public List<Integer> partitionLabels(String s) {
        int[][] intervals = new int[26][2];
        int len = s.length();
        for(int i=0; i<len; i++){
            int index = s.charAt(i)-'a';
            if(intervals[index][0] == 0)
                intervals[index][0] = i+1;
            intervals[index][1] = i+1;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] interval = new int[]{1,1};
        List<Integer> list = new LinkedList<>();
        boolean added = false;
        for(int i=0; i<26; i++){
            if(intervals[i][0] == 0)
                continue;
            if(isOverlaping(interval, intervals[i])){
                if(interval[1] < intervals[i][1])
                    interval[1] = intervals[i][1];
            }else{
                list.add(interval[1] - interval[0] + 1);
                interval = intervals[i];
            }
        }
        list.add(interval[1] - interval[0] + 1);
        return list;
    }
    private boolean isOverlaping(int[] iv1, int[] iv2){
        return iv1[1] >= iv2[0];
    }
}