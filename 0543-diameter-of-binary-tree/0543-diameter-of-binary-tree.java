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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        int max = depth(root.left) + depth(root.right);
        max = Math.max(Math.max(max, diameterOfBinaryTree(root.right)), diameterOfBinaryTree(root.left));
        return max;
    }
    private int depth(TreeNode node){
        if(node == null)
            return 0;
        return 1 + Math.max(depth(node.left), depth(node.right));
    }
}