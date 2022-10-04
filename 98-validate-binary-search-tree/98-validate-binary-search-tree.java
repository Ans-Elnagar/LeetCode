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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isValid(TreeNode node, long min, long max){
        if(node == null)
            return true;
        if( min > max || node.val > max || node.val < min)
            return false;
        return isValid(node.left, min, node.val-1l) && isValid(node.right, node.val+1l, max);
    }
}