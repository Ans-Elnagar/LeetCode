class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (first, second) -> Integer.compare(first[0], second[0]) );
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int i=1; i<intervals.length; i++) {
            int[] element = intervals[i];
        	int[] lastMergedInterval = list.get(list.size() - 1);
        	if(element[0] >= lastMergedInterval[0] && element[0] <= lastMergedInterval[1]) {
        		if(lastMergedInterval[1] < element[1])
        			lastMergedInterval[1] = element[1];
        	}else {
        		list.add(element);
        	}
        }
        int[][] mergedIntervals = new int[list.size()][];
        for(int i=0; i<list.size(); i++) {
        	mergedIntervals[i] = list.get(i);
        }
        return mergedIntervals;
    }
}