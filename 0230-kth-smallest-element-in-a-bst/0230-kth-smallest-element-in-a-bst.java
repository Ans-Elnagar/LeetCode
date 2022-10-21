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
    int val = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k, 1);
        return val;
    }
    private int dfs(TreeNode node, int k, int prevCount){
        if(node == null)
            return prevCount;
        int count = dfs(node.left, k, prevCount);
        if(count == k)
            this.val = node.val;
        if(count > k)
            return count;
        return dfs(node.right, k, count+1);
    }
}