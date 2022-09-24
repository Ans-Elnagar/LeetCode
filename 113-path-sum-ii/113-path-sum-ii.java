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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> allPaths = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        addPaths(allPaths, path, root, targetSum);
        return allPaths;
    }
    public void addPaths(List<List<Integer>> allPaths, LinkedList<Integer> path, TreeNode root, int targetSum) {
        if(root == null)
            return;
        targetSum -= root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(targetSum == 0){
                allPaths.add(new LinkedList<Integer>(path));
            }
        }
        addPaths(allPaths, path, root.left, targetSum);
        addPaths(allPaths, path, root.right, targetSum);
        path.removeLast();
        
    }
}