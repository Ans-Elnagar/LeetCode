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
        Queue<TreeNode> containsP = new LinkedList<>();
        Queue<TreeNode> containsQ = new LinkedList<>();
        doesContain(containsP, root, p);
        doesContain(containsQ, root, q);
        Set<TreeNode> set = new HashSet<>();
        while(!containsP.isEmpty())
            set.add(containsP.remove());
        while(!containsQ.isEmpty()){
            TreeNode node = containsQ.remove();
            if(set.contains(node))
                return node;
        }
        return null;
    }
    private boolean doesContain(Queue<TreeNode> list, TreeNode node, TreeNode find){
        if(node == null)
            return false;
        if(node.val == find.val){
            list.add(node);
            return true;
        }
        if(doesContain(list, node.left, find) || doesContain(list, node.right, find)){
            list.add(node);
            return true;
        }
        return false;
    }
}