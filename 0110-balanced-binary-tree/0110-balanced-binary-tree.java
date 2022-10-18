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
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }
    private int height(TreeNode node){
        if(node == null)
            return 0;
        int left = height(node.left) + 1;
        int right = height(node.right) + 1;
        if(left < 0 || right < 0 || Math.abs(left - right) > 1)
            return Integer.MIN_VALUE;
        return Math.max(left, right);
    }
}