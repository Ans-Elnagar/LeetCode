/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        return paths(map, root, 0, targetSum);
    }
    private int paths(Map<Long, Integer> map, TreeNode node, long prevSum, int targetSum){
        if(node == null)
            return 0;
        prevSum += node.val;
        map.put(prevSum, map.getOrDefault(prevSum, 0)+1);
        int count = 0;
        if(prevSum == targetSum)
            count++;
        if(map.containsKey(prevSum - targetSum))
            count += map.get(prevSum - targetSum);
        if(targetSum == 0)
            count--;
        count += paths(map, node.left, prevSum, targetSum);
        count += paths(map, node.right, prevSum, targetSum);
        map.put(prevSum, map.get(prevSum)-1);
        return count;
    }
}