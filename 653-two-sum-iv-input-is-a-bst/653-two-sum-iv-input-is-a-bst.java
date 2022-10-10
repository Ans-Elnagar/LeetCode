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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return foundTarget(set, root, k);
    }
    private boolean foundTarget(HashSet<Integer> set, TreeNode node, int k){
        if(node == null)
            return false;
        if(set.contains(node.val))
            return true;
        set.add(k-node.val);
        return foundTarget(set, node.left, k) || foundTarget(set, node.right, k);
    }
}