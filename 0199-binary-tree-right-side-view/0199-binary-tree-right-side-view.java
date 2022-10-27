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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList();
        Queue<TreeNode> queue = new LinkedList();
        if(root == null)
            return list;
        queue.add(root);
        while( ! queue.isEmpty() ){
            int size = queue.size();
            int val=0;
            while(size-->0){
                TreeNode node = queue.remove();
                val = node.val;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            list.add(val);
        }
        return list;
    }
}