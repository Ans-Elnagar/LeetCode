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
        // making p always bigger or equal
        int lenP = containsP.size();
        int lenQ = containsQ.size();
        if(lenP < lenQ){
            Queue<TreeNode> temp = containsP;
            containsP = containsQ;
            containsQ = temp;
            int lenTemp = lenP;
            lenP = lenQ;
            lenQ = lenTemp;
        }
        int diffLen = lenP - lenQ;
        while(diffLen-->0)
            containsP.remove();
        while(!containsP.isEmpty()){
            TreeNode t1 = containsP.remove();
            TreeNode t2 = containsQ.remove();
            if(t1 == t2)
                return t1;
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