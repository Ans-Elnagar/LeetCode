import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        recurse(result, new LinkedList<Integer>(), candidates, 0, target);
        return result;
    }
    
    private void recurse(LinkedList<List<Integer>> result,LinkedList<Integer> list,
                         int[] candidates, int index, int target){
        if(target < 0)
            return;
        if(target == 0){
            result.add(new ArrayList(list));
            return;
        }
        for(int i = index; i<candidates.length; i++){
            list.add(candidates[i]);
            recurse(result, list, candidates, i, target - candidates[i]);
            list.removeLast();
        }
    }
}