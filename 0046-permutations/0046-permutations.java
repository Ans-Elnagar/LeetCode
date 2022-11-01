class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        LinkedList<Integer> l = new LinkedList<>();
        rec(list, l, nums.length, nums);
        return list;
    }
    public void rec(List<List<Integer>> list, LinkedList<Integer> l, int k,int[] nums){
		if(k==0) {
            List<Integer> p = new LinkedList<>();
            for(int i: l)
                p.add(nums[i-1]);
			list.add(p);
            return;
		}
		for(int i=1; i<=nums.length; i++) {
            if(l.contains(i))
                continue;
			l.add(i);
			rec(list, l, k-1, nums);
			l.removeLast();
		}
	}
}