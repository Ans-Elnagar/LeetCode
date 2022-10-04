/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val){
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        int min = -1000_000_000;
        int max = 1000_000_000;
        TreeNode parent, current;
        parent = current = root;
        while(inRange(min, max, p.val, q.val)){
            parent = current;
            if(current.left != null && q.val < current.val){
                max = current.val - 1;
                current = current.left;
            }else{
                min = current.val + 1;
                current = current.right;
            }
        }
        return parent;
    }
    private boolean inRange(int min, int max, int p, int q){
        return min <= p && p <= max
            && min <= q && q <= max;
    }
}